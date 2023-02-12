package com.xuanluan.mc.org.model.request;

import com.xuanluan.mc.domain.model.request.FileRequest;
import com.xuanluan.mc.domain.validation.file.ValidImage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Xuan Luan
 * @createdAt 12/30/2022
 */
@Getter
@Setter
public class NewOrganization {
    @NotBlank(message = "Xin vui lòng điền tên cho tổ chức")
    private String name;
    private String description;
    private String address;
    @NotBlank(message = "Nhập địa chỉ email để liên hệ")
    @Email(message = "Đây không phải là địa chỉ email")
    private String email;
    @NotBlank(message = "Nhập số điện thoại liên hệ")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Số điện thoại không hợp lệ!")
    private String phoneNumber;
    private String referUrl;
    private String language;
    private String country;
    private String createdBy;
    @ValidImage
    private FileRequest file;
    private String leaderName;
}
