package com.xuanluan.mc.org.model.common;

import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.model.entity.OrganizationLogo;
import com.xuanluan.mc.org.model.entity.StorageProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDetail {
    private Organization organization;
    private OrganizationInfo organizationInfo;
    private StorageProvider storageProvider;
    private OrganizationLogo organizationLogo;

    public OrganizationDetail(Organization organization, OrganizationInfo organizationInfo, OrganizationLogo organizationLogo) {
        this.organization = organization;
        this.organizationInfo = organizationInfo;
        this.organizationLogo = organizationLogo;
    }
}
