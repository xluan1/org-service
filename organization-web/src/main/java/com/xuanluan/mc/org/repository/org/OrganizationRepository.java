package com.xuanluan.mc.org.repository.org;

import com.xuanluan.mc.org.model.entity.Organization;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
public interface OrganizationRepository extends CrudRepository<Organization, String>, OrgRepositoryCustom<Organization> {
    Organization findByOrgId(String orgId);
}
