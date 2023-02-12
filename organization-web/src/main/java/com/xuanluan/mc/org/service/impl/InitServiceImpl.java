package com.xuanluan.mc.org.service.impl;

import com.xuanluan.mc.file.BaseLoadFile;
import com.xuanluan.mc.org.model.common.OrganizationDetail;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationClient;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.model.entity.StorageProvider;
import com.xuanluan.mc.org.model.enums.LanguageType;
import com.xuanluan.mc.org.model.enums.StorageProviderType;
import com.xuanluan.mc.org.model.enums.UnitStorage;
import com.xuanluan.mc.org.repository.org.OrganizationRepository;
import com.xuanluan.mc.org.repository.org_client.OrgClientRepository;
import com.xuanluan.mc.org.repository.org_info.OrganizationInfoRepository;
import com.xuanluan.mc.org.repository.storage.StorageProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;


/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
@RequiredArgsConstructor
@Service
public class InitServiceImpl extends BaseLoadFile {
    private final OrganizationRepository orgRepository;
    private final OrganizationInfoRepository orgInfoRepository;
    private final StorageProviderRepository providerRepository;
    private final OrgClientRepository orgClientRepository;

    @PostConstruct
    public void init() {
        String org_all_json_file = "organizationAll.json";
        createOrganizationDefault(org_all_json_file);
    }

    @Transactional(rollbackFor = Exception.class)
    void createOrganizationDefault(String fileName) {
        OrganizationDetail result = convertInputStream(fileName, OrganizationDetail.class);
        String clientId = "all";
        if (null != result) {
            Organization organization = result.getOrganization();
            if (orgClientRepository.findByClientIdAndOrgId(clientId, organization.getOrgId()) == null) {
                organization.setDefault(true);
                organization.setCreatedBy("server");
                organization.setLanguage(LanguageType.VN.value);

                orgRepository.save(organization);

                OrganizationInfo infoResult = result.getOrganizationInfo();
                infoResult.setOrgId(organization.getOrgId());
                infoResult.setCreatedAt(organization.getCreatedAt());
                infoResult.setCreatedBy(organization.getCreatedBy());

                orgInfoRepository.save(infoResult);

                StorageProvider provider = result.getStorageProvider();
                provider.setClientId("all");
                provider.setOrgId(organization.getOrgId());
                provider.setType(StorageProviderType.DATABASE.value);

                StorageProviderType type = StorageProviderType.getByValue(provider.getType());
                Assert.notNull(type, "Loại lưu trữ không hợp lệ!");
                provider.setName(type.label);
                provider.setUrl(type.url);
                provider.setUnit(UnitStorage.TB.name());

                providerRepository.save(provider);

                OrganizationClient organizationClient = new OrganizationClient();
                organizationClient.setClientId(clientId);
                organizationClient.setOrgId(organization.getOrgId());
                orgClientRepository.save(organizationClient);
            }
        }
    }
}
