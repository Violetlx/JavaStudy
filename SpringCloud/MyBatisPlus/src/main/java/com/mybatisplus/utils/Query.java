package com.mybatisplus.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页参数
 * @author lixuan
 * @Date 2024/8/8 9:28
 */
@Data
@Schema(name = "Query",description = "分页参数")
public class Query {
    /**
     * 当前页
     */
    @Schema(name = "current",description = "当前页")
    private Integer current;

    /**
     * 每页的数量
     */
    @Schema(name = "size",description = "每页的数量")
    private Integer size;

    /**
     * 正排序规则
     */
    @Schema(name = "asc",description = "正排序规则")
    private String asc;

    /**
     * 倒排序规则
     */
    @Schema(name = "desc",description = "倒排序规则")
    private String desc;
}
