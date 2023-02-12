package com.xuanluan.mc.org.controller.sa;

import com.xuanluan.mc.domain.model.WrapperResponse;
import com.xuanluan.mc.domain.model.filter.BaseFilter;
import com.xuanluan.mc.org.model.entity.Organization;
import com.xuanluan.mc.org.model.request.NewOrgClient;
import com.xuanluan.mc.org.model.request.NewOrganization;
import com.xuanluan.mc.org.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Xuan Luan
 * @createdAt 1/1/2023
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("sa/1.0.0")
public class OrganizationSuperAdminController {
    private final OrganizationService organizationService;

    @PostMapping("create_new_organization")
    public WrapperResponse createNewOrganization(@RequestBody @Valid NewOrganization request) {
        return WrapperResponse.builder()
                .status(HttpStatus.OK)
                .message("Thêm tổ chức mới thành công!")
                .data(organizationService.createNewOrganization(request))
                .build();
    }

    @PostMapping("add_organization_client/{clientId}")
    public WrapperResponse addOrganizationToClient(@PathVariable String clientId,
                                                   @RequestBody @Valid NewOrgClient request,
                                                   @RequestHeader(name = "X-CSRFToken") String token) {
        return WrapperResponse.builder()
                .status(HttpStatus.OK)
                .message("Thêm tổ chức mới thành công!")
                .data(organizationService.addOrganizationToClient(clientId, request, token))
                .build();
    }

    @PostMapping(value = "search_organization/{orgId}", produces = {APPLICATION_JSON_VALUE})
    public WrapperResponse searchOrganization(@PathVariable String orgId,
                                              @RequestBody BaseFilter request) {
        return WrapperResponse.builder()
                .status(HttpStatus.OK)
                .message("Hiển thị danh sách thành công!")
                .data(organizationService.searchOrganization(orgId, request))
                .build();
    }

    @PostMapping(value = "search_organization_client/{clientId}/{orgId}", produces = {APPLICATION_JSON_VALUE})
    public WrapperResponse searchOrganizationClient(@PathVariable String clientId,
                                                    @PathVariable String orgId,
                                                    @RequestBody BaseFilter request) {
        return WrapperResponse.builder()
                .status(HttpStatus.OK)
                .message("Hiển thị danh sách thành công!")
                .data(organizationService.searchOrganizationClient(clientId, orgId, request))
                .build();
    }

    @GetMapping("get_all_organization/{orgId}")
    public WrapperResponse<List<Organization>> getAllOrganization(@PathVariable String orgId) {
        return new WrapperResponse<>(
                HttpStatus.OK,
                "Hiển thị danh sách tổ chức thành công",
                organizationService.getOrganizations(orgId)
        );
    }
}
