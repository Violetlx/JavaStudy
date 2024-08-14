package com.cloud.service.service;

import com.cloud.service.domain.dto.CartFormDTO;
import com.cloud.service.domain.entity.CartEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.service.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

/**
* @author 1045754
* @description 针对表【cart(订单详情表)】的数据库操作Service
* @createDate 2024-08-12 15:34:29
*/
public interface ICartService extends IService<CartEntity> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}
