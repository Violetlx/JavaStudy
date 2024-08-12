package com.mybatisplus.service;

import com.mybatisplus.domain.dto.PageDTO;
import com.mybatisplus.domain.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatisplus.domain.query.UserQuery;
import com.mybatisplus.domain.vo.UserVO;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-07 17:27:57
*/
public interface IUserService extends IService<UserEntity> {

    boolean deductBalance(Long id, Integer money);

    PageDTO<UserVO> queryUsersPage(UserQuery query);
}
