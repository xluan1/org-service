package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author Xuan Luan
 * @createdAt 12/24/2022
 */
@Getter
@Setter
@ToString
@Entity
public class Organization extends BaseEntity {
    private String orgId;
    private String name;
    private String description;
    private boolean isCustomer;
    private boolean isDefault;
    private int language;
    private boolean isAllAccess;
}
