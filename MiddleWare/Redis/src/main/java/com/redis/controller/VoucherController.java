package com.redis.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.redis.domain.dto.Result;
import com.redis.domain.entity.SeckillVoucher;
import com.redis.domain.entity.Voucher;
import com.redis.service.ISeckillVoucherService;
import com.redis.service.IVoucherService;
import com.redis.utils.RedisIdWorker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 虎哥
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController {

    @Resource
    private IVoucherService voucherService;

    @Resource
    private RedisIdWorker redisIdWorker;

    @Resource
    private ISeckillVoucherService seckillVoucherService;

    /**
     * 新增秒杀券
     * @param voucher 优惠券信息，包含秒杀信息
     * @return 优惠券id
     */
    @PostMapping("seckill")
    public Result addSeckillVoucher(@RequestBody Voucher voucher) {
        voucherService.addSeckillVoucher(voucher);
        return Result.ok(voucher.getId());
    }

    /**
     * 新增普通券
     * @param voucher 优惠券信息
     * @return 优惠券id
     */
    @PostMapping
    public Result addVoucher(@RequestBody Voucher voucher) {
        voucher.setId(redisIdWorker.nextId("voucher"));
        voucherService.save(voucher);
        return Result.ok(voucher.getId());
    }


    /**
     * 查询店铺的优惠券列表
     * @param shopId 店铺id
     * @return 优惠券列表
     */
    @GetMapping("/list/{shopId}")
    public Result queryVoucherOfShop(@PathVariable("shopId") Long shopId) {
        Result result = voucherService.queryVoucherOfShop(shopId);
        System.out.println("result ===> "+result);
        return result;
    }

    /**
     * 查询优惠券
     * @param id Long
     * @return Result
     */
    @GetMapping("/{id}")
    public Result queryVoucherById(@PathVariable("id") Long id) {
        //首先获取优惠券列表
        List<Voucher> list = voucherService.list(Wrappers.lambdaQuery(Voucher.class)
                .eq(Voucher::getShopId, id));

        List<Long> idList = list.stream()
                .map(Voucher::getId)
                .toList();

        Map<Long, SeckillVoucher> seckillVoucherMap = seckillVoucherService.listByIds(idList)
                .stream()
                .collect(Collectors.toMap(SeckillVoucher::getVoucherId, Function.identity()));

        list.forEach(voucher -> {
            SeckillVoucher seckillVoucher = seckillVoucherMap.get(voucher.getId());
            if (seckillVoucher != null) {
                voucher.setId(seckillVoucher.getVoucherId());
                voucher.setBeginTime(seckillVoucher.getBeginTime());
                voucher.setEndTime(seckillVoucher.getEndTime());
                voucher.setStock(seckillVoucher.getStock());
            }
        });

        System.out.println("list ===> "+list);
        return Result.ok(list);
    }
}
