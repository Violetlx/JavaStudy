package com.cloud.service.controller;


import com.cloud.service.domain.dto.CartFormDTO;
import com.cloud.service.domain.entity.CartEntity;
import com.cloud.service.domain.vo.CartVO;
import com.cloud.service.service.ICartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车相关接口
 * @author lixuan
 */
@Tag(name = "购物车相关接口")
@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @PostMapping
    @Operation(summary = "添加商品到购物车")
    public void addItem2Cart(@Valid @RequestBody CartFormDTO cartFormDTO){
        cartService.addItem2Cart(cartFormDTO);
    }

    @PutMapping
    @Operation(summary = "更新购物车数据")
    public void updateCart(@RequestBody CartEntity cart){
        cartService.updateById(cart);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除购物车中商品")
    public void deleteCartItem(@Param ("购物车条目id")@PathVariable("id") Long id){
        cartService.removeById(id);
    }

    @GetMapping
    @Operation(summary = "查询购物车列表")
    public List<CartVO> queryMyCarts(){
        return cartService.queryMyCarts();
    }

    @DeleteMapping
    @Operation(summary = "批量删除购物车中商品")
    @Parameter(name = "ids", description = "购物车条目id集合")
    public void deleteCartItemByIds(@RequestParam("ids") List<Long> ids){
        cartService.removeByItemIds(ids);
    }
}
