package com.cloud.service.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.service.domain.entity.ItemEntity;
import com.cloudcommon.domain.PageDTO;
import com.cloud.service.domain.dto.ItemDTO;
import com.cloud.service.domain.query.ItemPageQuery;
import com.cloud.service.service.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索相关接口
 * @author lixuan
 */
@Tag(name = "搜索相关接口")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final IItemService itemService;

    @Operation(summary = "搜索商品")
    @GetMapping("/list")
    public PageDTO<ItemDTO> search(@ParameterObject ItemPageQuery query) {
        // 分页查询
        Page<ItemEntity> result = itemService.lambdaQuery()
                .like(StrUtil.isNotBlank(query.getKey()), ItemEntity::getName, query.getKey())
                .eq(StrUtil.isNotBlank(query.getBrand()), ItemEntity::getBrand, query.getBrand())
                .eq(StrUtil.isNotBlank(query.getCategory()), ItemEntity::getCategory, query.getCategory())
                .eq(ItemEntity::getStatus, 1)
                .between(query.getMaxPrice() != null, ItemEntity::getPrice, query.getMinPrice(), query.getMaxPrice())
                .page(query.toMpPage("update_time", false));
        // 封装并返回
        return PageDTO.of(result, ItemDTO.class);
    }
}
