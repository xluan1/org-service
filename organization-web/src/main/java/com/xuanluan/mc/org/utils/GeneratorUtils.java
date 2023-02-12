package com.xuanluan.mc.org.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Assert;

/**
 * @author Xuan Luan
 * @createdAt 1/6/2023
 */
public class GeneratorUtils {
    public static String generateRegexRandom() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        return RandomStringUtils.random(20, characters);
    }

    public static String generateUsernameFromEmail(String email) {
        Assert.notNull(email, "email must be not null");
        String splitEmail = email.split("@gmail")[0];

        return splitEmail.replaceAll("[^0-9a-zA-Z]", "");
    }

    public static void main(String[] args) {
        String email = "luan.d-ev;e'#l!o@per_2001+31\\)2123@gmail.com";
        System.out.println(generateUsernameFromEmail(email));
    }
}
