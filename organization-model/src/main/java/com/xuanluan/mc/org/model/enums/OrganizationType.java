package com.xuanluan.mc.org.model.enums;

/**
 * @author Xuan Luan
 * @createdAt 12/24/2022
 */
public enum OrganizationType {
    INTERNAL("Đội Ngũ Phát Triển"), EXTERNAL("Tổ Chức Ngoài");

    public final String label;

    OrganizationType(String label) {
        this.label = label;
    }
}
