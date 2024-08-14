package com.cloud.service.mapper;

import com.cloud.service.domain.entity.CartEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author 1045754
* @description 针对表【cart(订单详情表)】的数据库操作Mapper
* @createDate 2024-08-12 15:34:29
* @Entity com.cloud.service.domain.entity.Cart
*/
public interface CartMapper extends BaseMapper<CartEntity> {

    @Update("UPDATE cart SET num = num + 1 WHERE user_id = #{userId} AND item_id = #{itemId}")
    void updateNum(@Param("itemId") Long itemId, @Param("userId") Long userId);
}




