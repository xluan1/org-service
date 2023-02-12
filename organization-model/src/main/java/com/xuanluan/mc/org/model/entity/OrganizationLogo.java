package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @author Xuan Luan
 * @createdAt 2/5/2023
 */
@Getter
@Setter
@Entity
public class OrganizationLogo extends BaseEntity {
    @Lob
    private byte[] data;
    private String type;
    private String name;
    private String originFile;
    private String description;
}
