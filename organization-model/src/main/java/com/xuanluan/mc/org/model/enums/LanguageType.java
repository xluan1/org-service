package com.xuanluan.mc.org.model.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
@RequiredArgsConstructor
public enum LanguageType {
    VN(1, "Việt Nam"), EN(2, "Anh");

    public final int value;
    public final String label;
}
