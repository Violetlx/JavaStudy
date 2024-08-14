package com.cloud.service.domain.vo;

import com.cloud.service.domain.entity.ItemEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 商品表VO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ItemVO extends ItemEntity {

    @Serial
    private static final long serialVersionUID = 1L;
}
