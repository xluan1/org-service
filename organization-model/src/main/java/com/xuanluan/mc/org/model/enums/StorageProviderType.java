package com.xuanluan.mc.org.model.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author Xuan Luan
 * @createdAt 11/12/2022
 */
@RequiredArgsConstructor
public enum StorageProviderType {
    DATABASE(1, "Database", "Database"),
    AWS(2, "https://aws.amazon.com/vi/s3/", "Amazon S3"),
    GOOGLE(3, "https://console.cloud.google.com/", "Google Drive");

    public final int value;
    public final String url;
    public final String label;

    public static StorageProviderType getByValue(int value) {
        switch (value) {
            case 1:
                return StorageProviderType.DATABASE;
            case 2:
                return StorageProviderType.AWS;
            case 3:
                return StorageProviderType.GOOGLE;
            default:
                return null;
        }
    }
}
