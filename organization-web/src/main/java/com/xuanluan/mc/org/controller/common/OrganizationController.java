package com.xuanluan.mc.org.controller.common;

import com.xuanluan.mc.domain.model.WrapperResponse;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.entity.OrganizationInfo;
import com.xuanluan.mc.org.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("org/1.0.0")
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping("get_organization/{orgId}")
    public WrapperResponse<Organization> getOrganization(@PathVariable String orgId) {
        return new WrapperResponse<>(
                HttpStatus.OK,
                "Hiển thị thông tin thành công!",
                organizationService.getOrganization(orgId)
        );
    }

    @GetMapping("get_organization_info/{orgId}")
    public WrapperResponse<OrganizationInfo> getOrganizationInfo(@PathVariable String orgId) {
        return new WrapperResponse<>(
                HttpStatus.OK,
                "Hiển thị thông tin thành công!",
                organizationService.getOrganizationInfo(orgId)
        );
    }
}
