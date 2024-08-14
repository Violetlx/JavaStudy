package com.cloud.service.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * 登录表单实体
 * @author lixuan
 */
@Data
@Schema(description = "登录表单实体")
public class LoginFormDTO {
    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "是否记住我", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean rememberMe = false;
}
