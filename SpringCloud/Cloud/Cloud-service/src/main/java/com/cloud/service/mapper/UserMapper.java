package com.cloud.service.mapper;

import com.cloud.service.domain.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-08-12 15:34:29
* @Entity com.cloud.service.domain.entity.User
*/
public interface UserMapper extends BaseMapper<UserEntity> {

    @Update("update user set balance = balance - ${totalFee} where id = #{userId}")
    void updateMoney(@Param("userId") Long userId, @Param("totalFee") Integer totalFee);
}




