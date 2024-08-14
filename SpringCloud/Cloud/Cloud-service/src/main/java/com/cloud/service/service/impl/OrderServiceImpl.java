package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.dto.ItemDTO;
import com.cloud.service.domain.dto.OrderDetailDTO;
import com.cloud.service.domain.dto.OrderFormDTO;
import com.cloud.service.domain.entity.OrderDetailEntity;
import com.cloud.service.domain.entity.OrderEntity;
import com.cloud.service.service.ICartService;
import com.cloud.service.service.IItemService;
import com.cloud.service.service.IOrderDetailService;
import com.cloud.service.service.IOrderService;
import com.cloud.service.mapper.OrderMapper;
import com.cloudcommon.exception.BadRequestException;
import com.cloudcommon.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author 1045754
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity>
    implements IOrderService {

    private final IItemService itemService;
    private final IOrderDetailService detailService;
    private final ICartService cartService;


    @Override
    public Long createOrder(OrderFormDTO orderFormDTO) {
        // 1.订单数据
        OrderEntity order = new OrderEntity();
        // 1.1.查询商品
        List<OrderDetailDTO> detailDTOS = orderFormDTO.getDetails();
        // 1.2.获取商品id和数量的Map
        Map<Long, Integer> itemNumMap = detailDTOS.stream()
                .collect(Collectors.toMap(OrderDetailDTO::getItemId, OrderDetailDTO::getNum));
        Set<Long> itemIds = itemNumMap.keySet();
        // 1.3.查询商品
        List<ItemDTO> items = itemService.queryItemByIds(itemIds);
        if (items == null || items.size() < itemIds.size()) {
            throw new BadRequestException("商品不存在");
        }
        // 1.4.基于商品价格、购买数量计算商品总价：totalFee
        int total = 0;
        for (ItemDTO item : items) {
            total += item.getPrice() * itemNumMap.get(item.getId());
        }
        order.setTotalFee(total);
        // 1.5.其它属性
        order.setPaymentType(orderFormDTO.getPaymentType());
        order.setUserId(UserContext.getUser());
        order.setStatus(1);
        // 1.6.将Order写入数据库order表中
        save(order);

        // 2.保存订单详情
        List<OrderDetailEntity> details = buildDetails(order.getId(), items, itemNumMap);
        detailService.saveBatch(details);

        // 3.清理购物车商品
        cartService.removeByItemIds(itemIds);

        // 4.扣减库存
        try {
            itemService.deductStock(detailDTOS);
        } catch (Exception e) {
            throw new RuntimeException("库存不足！");
        }
        return order.getId();
    }

    @Override
    public void markOrderPaySuccess(Long orderId) {
        OrderEntity order = new OrderEntity();
        order.setId(orderId);
        order.setStatus(2);
        order.setPayTime(new Date());
        updateById(order);
    }

    private List<OrderDetailEntity> buildDetails(Long orderId, List<ItemDTO> items, Map<Long, Integer> numMap) {
        List<OrderDetailEntity> details = new ArrayList<>(items.size());
        for (ItemDTO item : items) {
            OrderDetailEntity detail = new OrderDetailEntity();
            detail.setName(item.getName());
            detail.setSpec(item.getSpec());
            detail.setPrice(item.getPrice());
            detail.setNum(numMap.get(item.getId()));
            detail.setItemId(item.getId());
            detail.setImage(item.getImage());
            detail.setOrderId(orderId);
            details.add(detail);
        }
        return details;
    }
}




