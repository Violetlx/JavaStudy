package com.redis.mapper;

import com.redis.domain.entity.Voucher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 1045754
* @description 针对表【tb_voucher】的数据库操作Mapper
* @createDate 2024-07-30 17:20:06
* @Entity com.redis.domain.entity.Voucher
*/
public interface VoucherMapper extends BaseMapper<Voucher> {
    List<Voucher> queryVoucherOfShop(@Param("shopId") Long shopId);
}




