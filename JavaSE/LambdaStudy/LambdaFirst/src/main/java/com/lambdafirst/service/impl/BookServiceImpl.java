package com.lambdafirst.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambdafirst.domain.entity.Book;
import com.lambdafirst.service.BookService;
import com.lambdafirst.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-12-19 17:14:10
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




