package com.hmall.user.controller;

import com.hmall.common.config.DefaultFeignConfig;
import com.hmall.common.utils.UserContext;
import com.hmall.user.domain.dto.LoginFormDTO;
import com.hmall.user.domain.vo.UserLoginVO;
import com.hmall.user.service.IUserService;
import com.user.service.api.feign.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @ApiOperation("用户登录接口")
    @PostMapping("login")
    public UserLoginVO login(@RequestBody @Validated LoginFormDTO loginFormDTO){
        return userService.login(loginFormDTO);
    }

    @ApiOperation("扣减余额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pw", value = "支付密码"),
            @ApiImplicitParam(name = "amount", value = "支付金额")
    })
    @PutMapping("/money/deduct")
    public void deductMoney(@RequestParam("pw") String pw,@RequestParam("amount") Integer amount){
        System.out.println("用户ID：" + UserContext.getUser());
        System.out.println("支付密码：" + pw);
        System.out.println("扣款金额：" + amount);
        userService.deductMoney(pw, amount);
    }
}

