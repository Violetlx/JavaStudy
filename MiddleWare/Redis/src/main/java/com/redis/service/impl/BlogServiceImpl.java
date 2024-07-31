package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.Blog;
import com.redis.service.IBlogService;
import com.redis.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_blog】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements IBlogService {

}




