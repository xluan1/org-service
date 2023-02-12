package com.xuanluan.mc.org.model.enums;

/**
 * @author Xuan Luan
 * @createdAt 1/6/2023
 */
public enum  EntityCharacter {
    ORGANIZATION("org"), ORGANIZATION_INFO("orgInf");

    public final String regex;

    EntityCharacter(String regex) {
        this.regex = regex;
    }
}
