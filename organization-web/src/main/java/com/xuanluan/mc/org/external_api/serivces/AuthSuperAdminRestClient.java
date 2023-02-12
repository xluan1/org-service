package com.xuanluan.mc.org.external_api.serivces;

import com.xuanluan.mc.auth.model.request.UserLocalRegisterRequest;
import com.xuanluan.mc.domain.model.WrapperResponse;
import com.xuanluan.mc.rest.BaseRestClient;
import com.xuanluan.mc.utils.PropertyReaderUtils;

/**
 * @author Xuan Luan
 * @createdAt 1/5/2023
 */
public class AuthSuperAdminRestClient extends BaseRestClient {

    public AuthSuperAdminRestClient(String clientId) {
        super(PropertyReaderUtils.getPropertyName("auth-sa-service.url"), clientId);
    }

    public WrapperResponse createAdmin(String orgId, UserLocalRegisterRequest request, String token) {
        return post("register_admin/" + orgId, request, token, WrapperResponse.class);
    }
}
