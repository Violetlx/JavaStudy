package com.cloud.service.controller;


import com.cloud.service.domain.entity.AddressEntity;
import com.cloudcommon.exception.BadRequestException;
import com.cloudcommon.utils.BeanUtils;
import com.cloudcommon.utils.CollUtils;
import com.cloudcommon.utils.UserContext;
import com.cloud.service.domain.dto.AddressDTO;
import com.cloud.service.service.IAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收货地址管理接口
 * @author lixuan
 */
@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@Tag(name = "收货地址管理接口")
public class AddressController {

    private final IAddressService addressService;

    /**
     * 根据id查询地址
     */
    @GetMapping("{addressId}")
    @Operation(summary = "根据id查询地址")
    public AddressDTO findAddressById(@RequestParam("地址id") @PathVariable("addressId") Long id) {
        // 1.根据id查询
        AddressEntity address = addressService.getById(id);
        // 2.判断当前用户
        Long userId = UserContext.getUser();
        if(!address.getUserId().equals(userId)){
            throw new BadRequestException("地址不属于当前登录用户");
        }
        return BeanUtils.copyBean(address, AddressDTO.class);
    }

    /**
     * 查询当前用户地址列表
     */
    @GetMapping
    @Operation(summary = "查询当前用户地址列表")
    public List<AddressDTO> findMyAddresses() {
        // 1.查询列表
        List<AddressEntity> list = addressService.query().eq("user_id", UserContext.getUser()).list();
        // 2.判空
        if (CollUtils.isEmpty(list)) {
            return CollUtils.emptyList();
        }
        // 3.转vo
        return BeanUtils.copyList(list, AddressDTO.class);
    }
}
