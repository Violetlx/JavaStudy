package com.cloud.service.service;

import com.cloud.service.domain.dto.LoginFormDTO;
import com.cloud.service.domain.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.service.domain.vo.UserLoginVO;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-12 15:34:29
*/
public interface IUserService extends IService<UserEntity> {

    void deductMoney(String pw, Integer amount);

    UserLoginVO login(LoginFormDTO loginFormDTO);
}
