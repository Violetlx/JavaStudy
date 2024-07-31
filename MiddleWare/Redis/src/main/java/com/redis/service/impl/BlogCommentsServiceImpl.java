package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.BlogComments;
import com.redis.service.IBlogCommentsService;
import com.redis.mapper.BlogCommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_blog_comments】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments>
    implements IBlogCommentsService {

}




