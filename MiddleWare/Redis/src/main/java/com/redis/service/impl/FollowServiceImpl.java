package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.Follow;
import com.redis.service.IFollowService;
import com.redis.mapper.FollowMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_follow】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow>
    implements IFollowService {

}




