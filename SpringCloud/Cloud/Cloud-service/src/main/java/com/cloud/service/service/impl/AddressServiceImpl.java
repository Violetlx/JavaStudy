package com.cloud.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.service.domain.entity.AddressEntity;
import com.cloud.service.service.IAddressService;
import com.cloud.service.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【address】的数据库操作Service实现
* @createDate 2024-08-12 15:34:29
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, AddressEntity>
    implements IAddressService {

}




