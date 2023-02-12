package com.xuanluan.mc.org.external_api.serivces;

import com.xuanluan.mc.domain.model.WrapperResponse;
import com.xuanluan.mc.domain.model.request.email.EmailSender;
import com.xuanluan.mc.rest.BaseRestClient;
import com.xuanluan.mc.utils.PropertyReaderUtils;

/**
 * @author Xuan Luan
 * @createdAt 2/10/2023
 */
public class ClientRestClient extends BaseRestClient {
    public ClientRestClient(String clientId) {
        super(PropertyReaderUtils.getPropertyName("client-service.url"), clientId);
    }

    public WrapperResponse sendEmailFromClient(EmailSender request) {
        return post("send_email_from_client", request, WrapperResponse.class);
    }
}
