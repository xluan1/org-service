package com.xuanluan.mc.org.service;

import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.domain.model.filter.ResultList;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationClient;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.model.request.NewOrgClient;
import com.xuanluan.mc.org.model.request.NewOrganization;

import java.util.List;

/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
public interface OrganizationService {
    OrganizationClient addOrganizationToClient(String clientId, NewOrgClient request, String token);

    Organization createNewOrganization(NewOrganization request);

    ResultList<Organization> searchOrganization(String orgId, BaseFilter filter);

    List<Organization> getOrganizations(String orgId);

    ResultList<OrganizationClient> searchOrganizationClient(String clientId, String orgId, BaseFilter filter);

    Organization getOrganization(String orgId);

    OrganizationInfo getOrganizationInfo(String orgId);
}
