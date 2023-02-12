package com.xuanluan.mc.org.repository.org;

import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.domain.model.filter.ResultList;

import java.util.List;

/**
 * @author Xuan Luan
 * @createdAt 12/29/2022
 */
public interface OrgRepositoryCustom<T> {

    List<T> findAll();

    ResultList<T> searchFullText(String orgId, BaseFilter filter);
}
