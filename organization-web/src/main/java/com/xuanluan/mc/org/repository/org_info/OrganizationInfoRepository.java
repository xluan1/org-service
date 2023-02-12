package com.xuanluan.mc.org.repository.org_info;

import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
public interface OrganizationInfoRepository extends CrudRepository<OrganizationInfo, String> {
    OrganizationInfo findByOrgId(String orgId);
}
