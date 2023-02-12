package com.xuanluan.mc.org.model.entity;

import com.xuanluan.mc.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * maxSize of StorageProvider = capacity * value of unit => max size byte
 *
 * @author Xuan Luan
 * @createdAt 12/19/2022
 */
@Getter
@Setter
@ToString
@Entity
public class StorageProvider extends BaseEntity {
    private String clientId;
    private String orgId;
    private String name;
    private int type;
    private String url;
    private String unit;//UnitStorage enum
    private double capacity;
    private long currentSize;
}
