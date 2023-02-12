package com.xuanluan.mc.org.repository.org_client;

import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.domain.model.filter.ResultList;

/**
 * @author Xuan Luan
 * @createdAt 2/10/2023
 */
public interface OrgClientRepositoryCustom<T> {
    ResultList<T> searchFullText(String clientId, String orgId, BaseFilter filter);
}
