package com.redis.service;

import com.redis.domain.dto.Result;
import com.redis.domain.entity.Voucher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1045754
* @description 针对表【tb_voucher】的数据库操作Service
* @createDate 2024-07-30 17:20:06
*/
public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);

}
