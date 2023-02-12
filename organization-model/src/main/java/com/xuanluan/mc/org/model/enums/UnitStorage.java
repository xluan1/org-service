package com.xuanluan.mc.org.model.enums;

/**
 * 1KB= 1024bytes
 * 1MB = 1024 * 1024
 * 1GB = 1024 * 1024 * 1024
 * 1TB = 1024 * 1024 * 1024 * 1024
 *
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
public enum UnitStorage {
    TB(1099511627776L), GB(1073741824), MB(1048576);

    public final long value;

    UnitStorage(long value) {
        this.value = value;
    }
}
