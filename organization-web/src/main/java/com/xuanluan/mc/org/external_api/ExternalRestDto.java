package com.xuanluan.mc.org.external_api;

import com.xuanluan.mc.org.external_api.serivces.AuthSuperAdminRestClient;
import com.xuanluan.mc.org.external_api.serivces.ClientRestClient;
import lombok.Getter;

/**
 * @author Xuan Luan
 * @createdAt 1/7/2023
 */
@Getter
public class ExternalRestDto {
    private final AuthSuperAdminRestClient authSuperAdminRest;
    private final ClientRestClient clientRest;

    public ExternalRestDto(String clientId) {
        this.authSuperAdminRest = new AuthSuperAdminRestClient(clientId);
        this.clientRest = new ClientRestClient(clientId);
    }
}
