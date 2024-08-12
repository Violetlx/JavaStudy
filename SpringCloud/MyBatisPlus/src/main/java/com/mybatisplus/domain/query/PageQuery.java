package com.mybatisplus.domain.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author lixuan
 * @Date 2024/8/9 11:57
 */
@Data
@Schema(description = "分页查询实体")
public class PageQuery {
    @Schema(description = "页码")
    private Long pageNo;
    @Schema(description = "页码")
    private Long pageSize;
    @Schema(description = "排序字段")
    private String sortBy;
    @Schema(description = "是否升序")
    private Boolean isAsc;

    public <T> Page<T> toMpPage(OrderItem... orders){
        // 1.分页条件
        Page<T> p = Page.of(pageNo, pageSize);
        // 2.排序条件
        // 2.1.先看前端有没有传排序字段
        if (sortBy != null) {
            p.addOrder(isAsc!= null&& isAsc ? OrderItem.asc(sortBy) : OrderItem.desc(sortBy));
            return p;
        }
        // 2.2.再看有没有手动指定排序字段
        if(orders != null){
            p.addOrder(orders);
        }
        return p;
    }

    public <T> Page<T> toMpPage(String defaultSortBy, boolean isAsc){
        return this.toMpPage(isAsc ? OrderItem.asc(defaultSortBy) : OrderItem.desc(defaultSortBy));
    }

    public <T> Page<T> toMpPageDefaultSortByCreateTimeDesc() {
        return toMpPage("create_time", false);
    }

    public <T> Page<T> toMpPageDefaultSortByUpdateTimeDesc() {
        return toMpPage("update_time", false);
    }
}
