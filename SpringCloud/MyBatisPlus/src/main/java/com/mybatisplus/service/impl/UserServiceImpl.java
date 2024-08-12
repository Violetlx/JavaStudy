package com.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.domain.dto.PageDTO;
import com.mybatisplus.domain.entity.UserEntity;
import com.mybatisplus.domain.query.UserQuery;
import com.mybatisplus.domain.vo.UserVO;
import com.mybatisplus.service.IUserService;
import com.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
* @author 1045754
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-08-07 17:27:57
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>
    implements IUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deductBalance(Long id, Integer money) {
        //1、查询用户
        UserEntity user = getById(id);
        //2、校验用户状态
        if (user == null || user.getStatus().getValue()== 2) {
            throw new RuntimeException("用户状态异常！");
        }
        //3、校验余额是否充足
        if (user.getBalance() < money) {
            throw new RuntimeException("余额不足！");
        }
        //4、扣减余额
        int remainBalance = user.getBalance() - money;
        return lambdaUpdate()
                .set(UserEntity::getBalance,remainBalance)
                .set(remainBalance==0,UserEntity::getStatus,2)
                .eq(UserEntity::getId,id)
                //乐观锁
                .eq(UserEntity::getBalance,user.getBalance())
                .update();
    }

    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        // 1.构建条件
        // 1.1.分页条件
        Page<UserEntity> page = Page.of(query.getPageNo(), query.getPageSize());
        // 1.2.排序条件
        if (query.getSortBy() != null) {
            page.addOrder(query.getIsAsc()!= null&& query.getIsAsc() ? OrderItem.asc(query.getSortBy()) : OrderItem.desc(query.getSortBy()));
        }else{
            // 默认按照更新时间排序
            page.addOrder(OrderItem.desc("update_time"));
        }
        // 2.查询
        page(page);
        // 3.数据非空校验
        List<UserEntity> records = page.getRecords();
        if (records == null || records.size() <= 0) {
            // 无数据，返回空结果
            return new PageDTO<>(page.getTotal(), page.getPages(), Collections.emptyList());
        }
        // 4.有数据，转换
        List<UserVO> list = BeanUtil.copyToList(records, UserVO.class);
        // 5.封装返回
        return new PageDTO<>(page.getTotal(), page.getPages(), list);
    }
}




