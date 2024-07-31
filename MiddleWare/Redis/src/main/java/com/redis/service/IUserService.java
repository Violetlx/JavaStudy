package com.redis.service;

import com.redis.domain.dto.LoginFormDTO;
import com.redis.domain.dto.Result;
import com.redis.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpSession;

/**
* @author 1045754
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();

}
