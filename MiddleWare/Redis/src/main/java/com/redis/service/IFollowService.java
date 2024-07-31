package com.redis.service;

import com.redis.domain.dto.Result;
import com.redis.domain.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【tb_follow】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, Boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);

}
