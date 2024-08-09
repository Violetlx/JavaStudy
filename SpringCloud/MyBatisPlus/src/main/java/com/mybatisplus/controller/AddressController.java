package com.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.domain.entity.AddressEntity;
import com.mybatisplus.service.IAddressService;
import com.mybatisplus.utils.ConditionUtil;
import com.mybatisplus.utils.Query;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址控制器
 * @author lixuan
 * @Date 2024/8/7 17:38
 */
@RestController
@RequestMapping("/address")
@Tag(name = "地址控制器")
@RequiredArgsConstructor
public class AddressController {

    @Resource
    private IAddressService addressService;

    /**
     * 查询地址
     */
    @GetMapping("/getAddressById")
    @Operation(summary = "根据id查询地址 getAddressById")
    public AddressEntity getAddressById(@RequestParam Long id) {
        return addressService.getById(id);
    }

    /**
     * 查询所有地址
     */
    @GetMapping("/getAddress")
    @Operation(summary = "查询所有地址 getAddress")
    @Parameters({@Parameter(name = "province", description = "省", required = false),
            @Parameter(name = "city", description = "市", required = false)})
    public List<AddressEntity> getAddress(@ParameterObject AddressEntity addressEntity) {
        return addressService.list(ConditionUtil.buildQueryWrapper(addressEntity, AddressEntity.class));
    }

    /**
     * 分页查询地址
     */
    @GetMapping("/getAddressByPage")
    @Operation(summary = "分页查询地址 getAddressByPage")
    public Page<AddressEntity> getAddressByPage(@ParameterObject AddressEntity addressEntity,@ParameterObject Query query) {
        QueryWrapper<AddressEntity> queryWrapper = ConditionUtil.buildQueryWrapper(addressEntity, AddressEntity.class);
        return addressService.page(new Page<>(query.getCurrent(), query.getSize()), queryWrapper);
    }

    /**
     * 新增地址
     */
    @PostMapping("/addAddress")
    @Operation(summary = "新增地址 addAddress")
    public boolean addAddress(@RequestBody AddressEntity addressEntity) {
        return addressService.save(addressEntity);
    }

    /**
     * 修改地址
     */
    @PutMapping("/updateAddress")
    @Operation(summary = "修改地址 updateAddress")
    public boolean updateAddress(@RequestBody AddressEntity addressEntity) {
        return addressService.updateById(addressEntity);
    }

    /**
     * 删除地址
     */
    @DeleteMapping("/deleteAddress")
    @Operation(summary = "删除地址 deleteAddress")
    public boolean deleteAddress(@RequestParam Long id) {
        return addressService.removeById(id);
    }

    /**
     * 批量删除地址
     */
    @DeleteMapping("/deleteAddressBatch")
    @Operation(summary = "批量删除地址 deleteAddressBatch")
    public boolean deleteAddressBatch(@RequestParam List<Long> ids) {
        return addressService.removeBatchByIds(ids);
    }
}
