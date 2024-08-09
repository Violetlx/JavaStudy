package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.domain.entity.UserEntity;
import com.mybatisplus.service.IUserService;
import com.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}




