package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.domain.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-08-07 17:27:57
* @Entity com.mybatisplus.domain.entity.UserEntity
*/
public interface UserMapper extends BaseMapper<UserEntity> {

    @Select("UPDATE user SET balance = balance - #{money} ${ew.customSqlSegment}")
    void deductBalanceByIds(@Param("money") int money, @Param("ew") QueryWrapper<UserEntity> wrapper);
}




