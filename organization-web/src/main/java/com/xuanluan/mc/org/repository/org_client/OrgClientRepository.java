package com.xuanluan.mc.org.repository.org_client;

import com.xuanluan.mc.org.model.entity.OrganizationClient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xuan Luan
 * @createdAt 2/4/2023
 */
public interface OrgClientRepository extends CrudRepository<OrganizationClient, String>, OrgClientRepositoryCustom<OrganizationClient> {
    OrganizationClient findByClientIdAndOrgId(String clientId, String orgId);
}
