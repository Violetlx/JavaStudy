package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.UserInfo;
import com.redis.service.IUserInfoService;
import com.redis.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_user_info】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements IUserInfoService {

}




