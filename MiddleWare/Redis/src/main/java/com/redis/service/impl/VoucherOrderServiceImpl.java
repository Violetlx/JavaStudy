package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.VoucherOrder;
import com.redis.service.IVoucherOrderService;
import com.redis.mapper.VoucherOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_voucher_order】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder>
    implements IVoucherOrderService {

}




