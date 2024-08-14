package com.cloud.service.service;

import com.cloud.service.domain.dto.ItemDTO;
import com.cloud.service.domain.dto.OrderDetailDTO;
import com.cloud.service.domain.entity.ItemEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
* @author 1045754
* @description 针对表【item(商品表)】的数据库操作Service
* @createDate 2024-08-12 15:34:29
*/
public interface IItemService extends IService<ItemEntity> {

    List<ItemDTO> queryItemByIds(Collection<Long> ids);

    void deductStock(List<OrderDetailDTO> items);
}
