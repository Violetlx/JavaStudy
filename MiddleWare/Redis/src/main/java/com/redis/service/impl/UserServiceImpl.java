package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.User;
import com.redis.service.IUserService;
import com.redis.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements IUserService {

}




