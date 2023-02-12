package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Xuan Luan
 * @createdAt 1/14/2023
 */
@Getter
@Setter
@Entity
public class OrganizationDev extends BaseEntity {
    private String clientId;
    private String orgId;
    private String service;
    private String swaggerUrl;
}
