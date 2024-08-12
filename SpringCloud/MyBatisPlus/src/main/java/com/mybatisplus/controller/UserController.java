package com.mybatisplus.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.domain.dto.PageDTO;
import com.mybatisplus.domain.dto.UserDTO;
import com.mybatisplus.domain.entity.AddressEntity;
import com.mybatisplus.domain.entity.UserEntity;
import com.mybatisplus.domain.query.UserQuery;
import com.mybatisplus.domain.vo.AddressVO;
import com.mybatisplus.domain.vo.UserVO;
import com.mybatisplus.eum.UserStatus;
import com.mybatisplus.service.IAddressService;
import com.mybatisplus.service.IUserService;
import com.mybatisplus.utils.ConditionUtil;
import com.mybatisplus.utils.Query;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户控制器
 * @author lixuan
 * @Date 2024/8/7 17:38
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户控制器")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;
    private final IAddressService addressService;

    /**
     * 查询用户
     */
    @GetMapping("/getUser/{id}")
    @Operation(summary = "查询用户 getUser/{id}")
    public UserVO getUser(@Parameter(description = "用户ID") @PathVariable("id") Long id) {
        UserEntity userEntity = userService.getById(id);
        return BeanUtil.copyProperties(userEntity, UserVO.class);
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/getAllUser")
    @Operation(summary = "查询所有用户 getAllUser", ignoreJsonView = true)
    public List<UserVO> getAllUser(@ParameterObject UserEntity userEntity) {
        QueryWrapper<UserEntity> queryWrapper = ConditionUtil.buildQueryWrapper(userEntity, UserEntity.class);
        System.out.println("queryWrapper ===> "+queryWrapper);
        List<UserEntity> userEntityList = userService.list(queryWrapper);
        List<UserVO> userVOS = BeanUtil.copyToList(userEntityList, UserVO.class);
        userVOS.forEach(userVO -> System.out.println(userVO.getUsername()));
        return BeanUtil.copyToList(userEntityList, UserVO.class);
    }

    /**
     * 分页查询
     */
    @GetMapping("/getUserByPage")
    @Operation(summary = "分页查询 getUserByPage")
    public Page<UserEntity> getUserByPage(@ParameterObject UserEntity userEntity,@ParameterObject Query query) {
        QueryWrapper<UserEntity> queryWrapper = ConditionUtil.buildQueryWrapper(userEntity, UserEntity.class);
        Page<UserEntity> page = userService.page(new Page<>(query.getCurrent(), query.getSize()), queryWrapper);
        System.out.println("page ===> "+page);
        return userService.page(new Page<>(query.getCurrent(), query.getSize()), queryWrapper);
    }

    /**
     * 新增用户
     */
    @PostMapping("/addUser")
    @Operation(summary = "新增用户 addUser")
    public boolean addUser(@RequestBody UserDTO userDTO) {
        //1、把DTO转换为实体Entity
        UserEntity userEntity = BeanUtil.copyProperties(userDTO, UserEntity.class);
        return userService.save(userEntity);
    }

    /**
     * 修改用户
     */
    @PutMapping("/updateUser")
    @Operation(summary = "修改用户 updateUser")
    public boolean updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateById(userEntity);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/deleteUser")
    @Operation(summary = "删除用户 deleteUser")
    public boolean deleteUser(@RequestParam Long id) {
        return userService.removeById(id);
    }

    /**
     * 批量删除用户
     */
    @DeleteMapping("/deleteUserBatch")
    @Operation(summary = "批量删除用户 deleteUserBatch")
    public boolean deleteUserBatch(@RequestParam List<Long> ids) {
        return userService.removeByIds(ids);
    }

    /**
     * 扣减用户余额
     */
    @PutMapping("/{id}/deduction/{money}")
    @Operation(summary = "扣减用户余额 {id}/deduction/{money}")
    public boolean deductBalance(
            @Parameter(description = "用户id") @PathVariable("id") Long id,
            @Parameter(description = "扣减金额") @PathVariable("money") Integer money) {
        return userService.deductBalance(id, money);
    }

    /**
     * 查询用户并且对应其地址足迹
     */
    @GetMapping("/getUserAndAddress/{id}")
    @Operation(summary = "查询用户并且对应其地址足迹 getUserAndAddress/{id}")
    public UserVO getUserAndAddress(@Parameter(description = "用户ID") @PathVariable("id") Long id) {
        //获取用户
        UserEntity userEntity = userService.getById(id);
        if (userEntity == null || userEntity.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常！！");
        }
        //转换Vo
        UserVO userVO = BeanUtil.copyProperties(userEntity, UserVO.class);
        //获取地址列表
        List<AddressEntity> addressEntityList = addressService.list(Wrappers.lambdaQuery(AddressEntity.class)
                .eq(AddressEntity::getUserId, id));
        //转换列表VO
        if (CollUtil.isNotEmpty(addressEntityList)) {
            List<AddressVO> addressVOList = BeanUtil.copyToList(addressEntityList, AddressVO.class);
            userVO.setAddressList(addressVOList);
        }
        return userVO;
    }

    /**
     * 根据ids批量查询
     */
    @GetMapping("/getUserByIds")
    @Operation(summary = "根据ids批量查询 getUserByIds")
    public List<UserVO> getUserByIds(@RequestParam List<Long> ids) {
        //1、查询用户
        List<UserEntity> userEntityList = userService.listByIds(ids);
        if (CollUtil.isEmpty(userEntityList)) {
            return Collections.emptyList();
        }
        //2查询地址列表
        List<AddressEntity> addressEntityList = addressService.list(Wrappers.lambdaQuery(AddressEntity.class)
                .in(AddressEntity::getUserId, ids));
        //转为Vo列表
        List<UserVO> userVOList = BeanUtil.copyToList(userEntityList, UserVO.class);
        //根据UserId转为Map
        Map<Long, List<AddressEntity>> addressEntityMap = addressEntityList.stream()
                .collect(Collectors.groupingBy(AddressEntity::getUserId));
        userVOList.forEach(userVO -> {
            if (userVO.getStatus() == UserStatus.FREEZE) {
                log.error("用户{}状态异常！！", userVO.getUsername());
            }

            //1、获取对应地址列表
            Optional.ofNullable(addressEntityMap.get(userVO.getId()))
                    .ifPresent(addressEntities -> {
                        //2、转换为Vo地址列表
                        List<AddressVO> addressVOList = BeanUtil.copyToList(addressEntities, AddressVO.class);
                        //3、注入Vo
                        userVO.setAddressList(addressVOList);
                    });
        });
        return userVOList;
    }

    /**
     * 分页查询 page
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询 page")
    public PageDTO<UserVO> queryUsersPage(@ParameterObject UserQuery query){
        log.info("queryUsersPage ===> {}", query);
        Page<UserEntity> userEntityPage = userService.page(new Page<UserEntity>(query.getPageNo(), query.getPageSize())
                        .addOrder(ObjectUtil.isEmpty(query.getSortBy()) ?
                                OrderItem.desc("update_time") :
                                (query.getIsAsc() != null && query.getIsAsc() ?
                                        OrderItem.asc(query.getSortBy()) :
                                        OrderItem.desc(query.getSortBy()))),
                Wrappers.lambdaQuery(UserEntity.class)
                        .like(StrUtil.isNotBlank(query.getName()), UserEntity::getUsername, query.getName())
                        .between(query.getMinBalance() != null && query.getMaxBalance() != null, UserEntity::getBalance, query.getMinBalance(), query.getMaxBalance()));
        System.out.println("userEntityPage = " + userEntityPage.getRecords());
        //转换为Vo
        List<UserVO> userVOList = BeanUtil.copyToList(userEntityPage.getRecords(), UserVO.class);
        PageDTO<UserVO> userVoPageDTO = new PageDTO<>(userEntityPage.getCurrent(), userEntityPage.getSize(), userVOList);
        userVoPageDTO.setTotal(userEntityPage.getTotal());
        System.out.println("userVoPageDTO = " + userVoPageDTO.getPages());
        return userService.queryUsersPage(query);
    }

}
