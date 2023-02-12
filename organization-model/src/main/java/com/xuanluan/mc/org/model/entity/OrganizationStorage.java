package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
@Getter
@Setter
@Entity
public class OrganizationStorage extends BaseEntity {
    private String clientId;
    private String orgId;
    private String storageProviderId;
    private String type; // png/jpg/...
    private String url;
    private String name;
    private String originFile;
    private String description;
    private long size;
    @Lob
    private byte[] photo;
}
