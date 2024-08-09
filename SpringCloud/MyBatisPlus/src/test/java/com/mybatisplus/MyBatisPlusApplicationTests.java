package com.mybatisplus;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.domain.entity.AddressEntity;
import com.mybatisplus.domain.entity.UserEntity;
import com.mybatisplus.eum.UserStatus;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.service.IAddressService;
import com.mybatisplus.service.IUserService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = MyBatisPlusApplication.class)
class MyBatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserService userService;
    @Resource
    private IAddressService addressService;

    /**
     * ①查询出名字中带o的,存款大于等于1000元的用户
     */
    @Test
    void testQueryMapper() {
        List<UserEntity> userEntityList = userMapper.selectList(Wrappers.lambdaQuery(UserEntity.class)
                .like(UserEntity::getUsername, "o")
                .ge(UserEntity::getBalance, 1000));
        System.out.println("userEntityList ===> "+userEntityList);
    }

    /**
     * ②更新用户名为Jack的用户余额为2000
     */
    @Test
    void testUpdateMapper() {
        userMapper.update(Wrappers.lambdaUpdate(UserEntity.class)
                .set(UserEntity::getBalance, 2000)
                .eq(UserEntity::getUsername, "Jack"));
    }

    /**
     * ③基于UpdateWrapper的更新 更新id为1、2、4的用户余额,扣200
     */
    @Test
    void testUpdateWrapper() {
        userMapper.update(null, Wrappers.<UserEntity>update().lambda()
                .setSql("balance = balance - 200")
                .in(UserEntity::getId, 1, 2, 4));
    }

    /**
     * 自定义SQL
     */
    @Test
    void testCustomWrapper() {
        // 1.准备自定义查询条件
        List<Long> ids = List.of(1L, 2L, 4L);
        // 2、定义条件
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<UserEntity>().in("id", ids);
        // 3.调用mapper的自定义方法，直接传递Wrapper
        userMapper.deductBalanceByIds(200, wrapper);
    }

    /**
     * 批量新增用户
     */
    @Test
    void testInsertBatch() {
        List<UserEntity> userEntityList = new ArrayList<>(1000);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("user_" + i);
            userEntity.setBalance(1000+i);
//            userEntity.setInfo(1);
            userEntity.setPhone("phone_"+i);
            userEntity.setStatus(UserStatus.NORMAL);
            userEntity.setPassword("password_"+i);
            userEntity.setCreateTime(new Date());
            userEntity.setUpdateTime(new Date());
//            userEntity.setInfo(JSONUtil.toJsonStr(1));
            userEntityList.add(userEntity);
            if (i%1000 == 0) {
                userService.saveBatch(userEntityList);
                //4、清空集合,准备下一批数据
                userEntityList.clear();
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println("耗时："+(l1-l));
    }

    /**
     * 地址逻辑删除
     */
    @Test
    void testDelete() {
        //1、删除
        addressService.removeById(59L);

        //2、查询
        AddressEntity addressEntity = addressService.getById(59L);
        System.out.println("addressEntity ===> "+addressEntity);
    }

    /**
     * 枚举处理测试
     */
    @Test
    void testService() {
        List<UserEntity> list = userService.list();
        list.forEach(System.out::println);
    }

    /**
     * 分页测试
     */
    @Test
    void testPageQuery() {
        // 1.分页查询，new Page()的两个参数分别是：页码、每页大小
        Page<UserEntity> p = userService.page(new Page<>(2, 2));
        // 2.总条数
        System.out.println("total = " + p.getTotal());
        // 3.总页数
        System.out.println("pages = " + p.getPages());
        // 4.数据
        List<UserEntity> records = p.getRecords();
        records.forEach(System.out::println);
    }
}
