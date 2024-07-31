package com.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.domain.entity.SeckillVoucher;
import com.redis.service.ISeckillVoucherService;
import com.redis.mapper.SeckillVoucherMapper;
import org.springframework.stereotype.Service;

/**
* @author 1045754
* @description 针对表【tb_seckill_voucher(秒杀优惠券表，与优惠券是一对一关系)】的数据库操作Service实现
* @createDate 2024-07-30 17:20:06
*/
@Service
public class SeckillVoucherServiceImpl extends ServiceImpl<SeckillVoucherMapper, SeckillVoucher>
    implements ISeckillVoucherService {

}




