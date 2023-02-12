package com.xuanluan.mc.org.repository.org_client;

import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.domain.model.filter.ResultList;
import com.xuanluan.mc.org.model.entity.OrganizationClient;
import com.xuanluan.mc.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xuan Luan
 * @createdAt 2/10/2023
 */
public class OrgClientRepositoryCustomImpl extends BaseRepository<OrganizationClient> implements OrgClientRepositoryCustom<OrganizationClient> {
    protected OrgClientRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager, OrganizationClient.class);
    }

    @Override
    public ResultList<OrganizationClient> searchFullText(String clientId, String orgId, BaseFilter filter) {
        HashMap<String, String> filterLikes = new HashMap<>();
        filterLikes.put("description", filter.getSearch());

        List<Predicate> filters = getFilterSearch(clientId, orgId, filterLikes, filter);

        return getResultList(filters, filter.getOffset(), filter.getMaxResult());
    }
}
