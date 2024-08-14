package com.cloud.service.domain.vo;

import com.cloud.service.domain.entity.AddressEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 地址表VO
 * @author lixuan
 * @Date 2024/8/12 15:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AddressVO extends AddressEntity {

    @Serial
    private static final long serialVersionUID = 1L;
}
