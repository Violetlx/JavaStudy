package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.domain.entity.AddressEntity;
import com.mybatisplus.service.IAddressService;
import com.mybatisplus.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【address(地址表)】的数据库操作Service实现
* @createDate 2024-08-07 17:27:57
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, AddressEntity>
    implements IAddressService {

}




