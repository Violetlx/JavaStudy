package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.ItemEntity;
import com.cloud.service.service.IItemService;
import com.cloud.service.mapper.ItemMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【item(商品表)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemEntity>
    implements IItemService {

}




