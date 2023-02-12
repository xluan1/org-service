package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Xuan Luan
 * @createdAt 12/24/2022
 */
@Getter
@Setter
@Entity
public class OrganizationInfo extends BaseEntity {
    private String orgId;
    private String address;
    private String phoneNumber;
    private String phoneNumber2;
    private String email;
    private String referUrl;
    private String country;
    private String hashCode;
    private String leaderName;
    private String orgLogoId;
}
