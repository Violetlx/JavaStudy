package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.dto.ItemDTO;
import com.cloud.service.domain.dto.OrderDetailDTO;
import com.cloud.service.domain.entity.ItemEntity;
import com.cloud.service.service.IItemService;
import com.cloud.service.mapper.ItemMapper;
import com.cloudcommon.exception.BizIllegalException;
import com.cloudcommon.utils.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
* @author 1045754
* @description 针对表【item(商品表)】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemEntity>
    implements IItemService {

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        return BeanUtils.copyList(listByIds(ids), ItemDTO.class);
    }

    @Override
    public void deductStock(List<OrderDetailDTO> items) {
        String sqlStatement = "com.cloud.service.mapper.ItemMapper.updateStock";
        boolean r = false;
        try {
            r = executeBatch(items, (sqlSession, entity) -> sqlSession.update(sqlStatement, entity));
        } catch (Exception e) {
            throw new BizIllegalException("更新库存异常，可能是库存不足!", e);
        }
        if (!r) {
            throw new BizIllegalException("库存不足！");
        }
    }
}




