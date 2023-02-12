package com.xuanluan.mc.org.utils;

import com.xuanluan.mc.exception.ServiceException;
import org.springframework.http.HttpStatus;

/**
 * @author Xuan Luan
 * @createdAt 2/4/2023
 */
public class ExceptionUtils {
    public static void organizationAlreadyExist(String clientId, String orgId) {
        throw new ServiceException(
                HttpStatus.CONFLICT,
                "Organization, orgId= " + orgId + " already exists in client=" + clientId,
                "Tổ chức: " + orgId + ", đã tồn tại trong dịch vụ: " + clientId
        );
    }

    public static void organizationNotFound(String orgId) {
        throw new ServiceException(HttpStatus.CONFLICT, "Not found Organization, orgId= " + orgId, "Không tìm thấy tổ chức: " + orgId);
    }
}
