package com.lambdafirst.mapper;

import com.lambdafirst.domain.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 1045754
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-12-19 17:14:10
* @Entity com.lambdafirst.domain.entity.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




