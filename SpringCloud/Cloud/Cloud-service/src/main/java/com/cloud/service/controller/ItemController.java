package com.cloud.service.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.domain.entity.ItemEntity;
import com.cloudcommon.domain.PageDTO;
import com.cloudcommon.domain.PageQuery;
import com.cloudcommon.utils.BeanUtils;
import com.cloud.service.domain.dto.ItemDTO;
import com.cloud.service.domain.dto.OrderDetailDTO;
import com.cloud.service.service.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 商品管理相关接口
 * @author 1045754
 */
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Tag(name = "商品管理相关接口")
public class ItemController {

    private final IItemService itemService;

    @GetMapping("/page")
    @Operation(summary = "分页查询商品")
    public PageDTO<ItemDTO> queryItemByPage(@ParameterObject PageQuery query) {
        // 1.分页查询
        Page<ItemEntity> result = itemService.page(query.toMpPage("update_time", false));
        // 2.封装并返回
        return PageDTO.of(result, ItemDTO.class);
    }

    @GetMapping
    @Operation(summary = "根据id批量查询商品")
    public List<ItemDTO> queryItemByIds(@RequestParam("ids") List<Long> ids){
        return itemService.queryItemByIds(ids);
    }

    @GetMapping("{id}")
    @Operation(summary = "根据id查询商品")
    public ItemDTO queryItemById(@PathVariable("id") Long id) {
        return BeanUtils.copyBean(itemService.getById(id), ItemDTO.class);
    }

    @PostMapping
    @Operation(summary = "新增商品")
    public void saveItem(@RequestBody ItemDTO item) {
        // 新增
        itemService.save(BeanUtils.copyBean(item, ItemEntity.class));
    }

    @PutMapping("/status/{id}/{status}")
    @Operation(summary = "更新商品状态")
    public void updateItemStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status){
        ItemEntity item = new ItemEntity();
        item.setId(id);
        item.setStatus(status);
        itemService.updateById(item);
    }

    @PutMapping
    @Operation(summary = "更新商品")
    public void updateItem(@RequestBody ItemDTO item) {
        // 不允许修改商品状态，所以强制设置为null，更新时，就会忽略该字段
        item.setStatus(null);
        // 更新
        itemService.updateById(BeanUtils.copyBean(item, ItemEntity.class));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "根据id删除商品")
    public void deleteItemById(@PathVariable("id") Long id) {
        itemService.removeById(id);
    }

    @PutMapping("/stock/deduct")
    @Operation(summary = "批量扣减库存")
    public void deductStock(@RequestBody List<OrderDetailDTO> items){
        itemService.deductStock(items);
    }
}
