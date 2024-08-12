package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.UserEntity;
import com.cloud.service.service.IUserService;
import com.cloud.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>
    implements IUserService {

}




