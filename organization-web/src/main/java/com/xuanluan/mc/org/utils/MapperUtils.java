package com.xuanluan.mc.org.utils;

import com.xuanluan.mc.domain.model.request.FileRequest;
import com.xuanluan.mc.org.model.common.OrganizationDetail;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.model.entity.OrganizationLogo;
import com.xuanluan.mc.org.model.enums.LanguageType;
import com.xuanluan.mc.org.model.request.NewOrganization;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
public class MapperUtils {
    /**
     * convert from orgId and NewOrganization to OrganizationDetail
     *
     * @param orgId   is sequenceValue
     * @param request NewOrganization
     * @return
     */
    public static OrganizationDetail convertToOrganizationDetail(String orgId, NewOrganization request) {
        Organization organization = new Organization();
        organization.setCustomer(true);
        organization.setDescription(request.getDescription());
        organization.setName(request.getName());
        organization.setOrgId(orgId);

        LanguageType languageType = LanguageType.valueOf(request.getLanguage());
        organization.setLanguage(languageType.value);
        organization.setCreatedBy(request.getCreatedBy());

        FileRequest file = request.getFile();
        OrganizationLogo logo = null;
        if (file != null) {
            logo = new OrganizationLogo();
            logo.setData(Base64.decodeBase64(file.getData()));
            logo.setDescription(file.getOriginalFile());
            logo.setName(file.getName());
            logo.setOriginFile(file.getOriginalFile());
            logo.setType(file.getType());
            logo.setCreatedBy(request.getCreatedBy());
        }

        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.setOrgId(organization.getOrgId());
        organizationInfo.setCreatedBy(organization.getCreatedBy());
        organizationInfo.setAddress(request.getAddress());
        organizationInfo.setEmail(request.getEmail());
        organizationInfo.setReferUrl(request.getReferUrl());
        organizationInfo.setLeaderName(request.getLeaderName());
        organizationInfo.setOrgLogoId(logo != null ? logo.getId() : null);

        return new OrganizationDetail(organization, organizationInfo, logo);
    }
}
