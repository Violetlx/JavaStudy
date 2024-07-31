package com.redis.service;

import com.redis.domain.dto.Result;
import com.redis.domain.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【tb_blog】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IBlogService extends IService<Blog> {

    Result queryHotBlog(Integer current);

    Result queryBlogById(Long id);

    Result likeBlog(Long id);

    Result queryBlogLikes(Long id);

    Result saveBlog(Blog blog);

    Result queryBlogOfFollow(Long max, Integer offset);


}
