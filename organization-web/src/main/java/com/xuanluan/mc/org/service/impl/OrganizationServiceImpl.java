package com.xuanluan.mc.org.service.impl;

import com.xuanluan.mc.auth.model.request.UserLocalRegisterRequest;
import com.xuanluan.mc.domain.entity.DataSequence;
import com.xuanluan.mc.domain.enums.SequenceType;
import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.domain.model.filter.ResultList;
import com.xuanluan.mc.exception.ServiceException;
import com.xuanluan.mc.org.external_api.serivces.AuthSuperAdminRestClient;
import com.xuanluan.mc.org.external_api.ExternalRestDto;
import com.xuanluan.mc.org.external_api.init.ExternalRestClientSingleton;
import com.xuanluan.mc.org.model.common.OrganizationDetail;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationClient;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.model.entity.OrganizationLogo;
import com.xuanluan.mc.org.model.enums.EntityCharacter;
import com.xuanluan.mc.org.model.request.NewOrgClient;
import com.xuanluan.mc.org.model.request.NewOrganization;
import com.xuanluan.mc.org.repository.org.OrganizationRepository;
import com.xuanluan.mc.org.repository.org_client.OrgClientRepository;
import com.xuanluan.mc.org.repository.org_info.OrganizationInfoRepository;
import com.xuanluan.mc.org.repository.org_logo.OrgLogoRepository;
import com.xuanluan.mc.org.repository.storage.StorageProviderRepository;
import com.xuanluan.mc.org.service.OrganizationService;
import com.xuanluan.mc.org.utils.ExceptionUtils;
import com.xuanluan.mc.org.utils.GeneratorUtils;
import com.xuanluan.mc.org.utils.MapperUtils;
import com.xuanluan.mc.service.impl.DataSequenceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
@RequiredArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository orgRepository;
    private final OrganizationInfoRepository orgInfoRepository;
    private final StorageProviderRepository providerRepository;
    private final DataSequenceServiceImpl sequenceService;
    private final OrgClientRepository orgClientRepository;
    private final OrgLogoRepository orgLogoRepository;

    private ExternalRestDto getRestClient(String clientId) {
        return ExternalRestClientSingleton.getExternalRest(clientId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrganizationClient addOrganizationToClient(String clientId, NewOrgClient request, String token) {
        OrganizationClient orgClient = orgClientRepository.findByClientIdAndOrgId(clientId, request.getOrgId());
        if (orgClient != null) ExceptionUtils.organizationAlreadyExist(clientId, request.getOrgId());

        OrganizationInfo info = orgInfoRepository.findByOrgId(request.getOrgId());
        if (info == null) ExceptionUtils.organizationNotFound(request.getOrgId());

        UserLocalRegisterRequest localRequest = new UserLocalRegisterRequest();
        localRequest.setEmail(info.getEmail());
        localRequest.setPassword(GeneratorUtils.generateRegexRandom());
        localRequest.setPassword2(localRequest.getPassword());
        //auto generate username= org+<orgId>+<username>
        String username = "org" + request.getOrgId() + GeneratorUtils.generateUsernameFromEmail(localRequest.getEmail());
        localRequest.setUsername(username);

        AuthSuperAdminRestClient authSAClient = getRestClient(clientId).getAuthSuperAdminRest();
        //status = 200 => success created
        authSAClient.createAdmin(request.getOrgId(), localRequest, token);

        //add Organization to Client
        orgClient = new OrganizationClient();
        orgClient.setOrgId(request.getOrgId());
        orgClient.setClientId(clientId);
        orgClient.setDescription(request.getDescription());
        orgClientRepository.save(orgClient);

        return orgClient;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Organization createNewOrganization(NewOrganization request) {
        //auto generate sequence increase
        DataSequence sequence =
                sequenceService.generateDataSequence("all", "all", Organization.class, SequenceType.NUMBER);
        String orgId = EntityCharacter.ORGANIZATION.regex + sequence.getSequenceValue();

        OrganizationDetail detail = MapperUtils.convertToOrganizationDetail(orgId, request);
        orgInfoRepository.save(detail.getOrganizationInfo());

        if (detail.getOrganizationLogo() != null) orgLogoRepository.save(detail.getOrganizationLogo());

        return orgRepository.save(detail.getOrganization());
    }

    @Override
    public ResultList<Organization> searchOrganization(String orgId, BaseFilter request) {
        return orgRepository.searchFullText(orgId, request);
    }

    @Override
    public List<Organization> getOrganizations(String orgId) {
        if (!"all".equals(orgId)) {
            throw new ServiceException(HttpStatus.FORBIDDEN, "No permission access to this function", "Không có quyền truy cập đến chức năng này");
        }
        return orgRepository.findAll();
    }

    @Override
    public ResultList<OrganizationClient> searchOrganizationClient(String clientId, String orgId, BaseFilter filter) {
        return orgClientRepository.searchFullText(clientId, orgId, filter);
    }

    @Override
    public Organization getOrganization(String orgId) {
        Organization organization = orgRepository.findByOrgId(orgId);
        if (organization == null) ExceptionUtils.organizationNotFound(orgId);
        return organization;
    }

    @Override
    public OrganizationInfo getOrganizationInfo(String orgId) {
        OrganizationInfo info = orgInfoRepository.findByOrgId(orgId);
        if (info == null) ExceptionUtils.organizationNotFound(orgId);
        Optional<OrganizationLogo> organizationLogo = orgLogoRepository.findById(info.getOrgLogoId());
        organizationLogo.ifPresent(logo -> {
            String base64 = Base64.encodeBase64String(logo.getData());
            info.setOrgLogoId("data:" + logo.getType() + ";base64, " + base64);
        });
        return info;
    }
}
