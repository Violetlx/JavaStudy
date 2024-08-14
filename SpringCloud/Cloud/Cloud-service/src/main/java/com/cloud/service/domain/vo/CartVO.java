package com.cloud.service.domain.vo;

import com.cloud.service.domain.entity.CartEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 订单详情表VO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@Schema(description = "购物车VO")
public class CartVO {

    @Schema(description = "购物车条目id ")
    private Long id;
    @Schema(description = "sku商品id")
    private Long itemId;
    @Schema(description = "购买数量")
    private Integer num;
    @Schema(description = "商品标题")
    private String name;
    @Schema(description = "商品动态属性键值集")
    private String spec;
    @Schema(description = "价格,单位：分")
    private Integer price;
    @Schema(description = "商品最新价格")
    private Integer newPrice;
    @Schema(description = "商品最新状态")
    private Integer status = 1;
    @Schema(description = "商品最新库存")
    private Integer stock = 10;
    @Schema(description = "商品图片")
    private String image;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
