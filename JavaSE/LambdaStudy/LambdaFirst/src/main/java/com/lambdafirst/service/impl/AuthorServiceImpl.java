package com.lambdafirst.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambdafirst.domain.entity.Author;
import com.lambdafirst.service.AuthorService;
import com.lambdafirst.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【author】的数据库操作Service实现
* @createDate 2023-12-19 17:33:00
*/
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
    implements AuthorService{

}




