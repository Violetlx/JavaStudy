package com.lambdafirst.mapper;

import com.lambdafirst.domain.entity.Author;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 1045754
* @description 针对表【author】的数据库操作Mapper
* @createDate 2023-12-19 17:33:00
* @Entity com.lambdafirst.domain.entity.Author
*/
@Mapper
public interface AuthorMapper extends BaseMapper<Author> {

}




