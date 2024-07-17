package com.xxljobdemo.xxljob;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxljobdemo.domain.UserMobilePlan;
import com.xxljobdemo.mapper.UserMobilePlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lixuan
 * @Date 2024/7/17 16:39
 */
@Component
public class SimpleXxlJob {
    @Resource
    private UserMobilePlanMapper userMobilePlanMapper;

    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        System.out.println("执行定时任务,执行时间:"+new Date());
    }

    @XxlJob("sendMsgHandler")
    public void sendMsgHandler() throws Exception{
        List<UserMobilePlan> userMobilePlans = userMobilePlanMapper.selectAll();
        System.out.println("任务开始时间:"+new Date()+",处理任务数量:"+userMobilePlans.size());
        Long startTime = System.currentTimeMillis();
        int shardTotal = XxlJobHelper.getShardTotal();
        int shardIndex = XxlJobHelper.getShardIndex();
        System.out.println("分片的总数:"+shardTotal+",分片的索引:"+shardIndex);
        userMobilePlans.forEach(item->{
            try {
                //模拟发送短信动作
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("任务结束时间:"+new Date());
        System.out.println("任务耗时:"+(System.currentTimeMillis()-startTime)+"毫秒");
    }

    @XxlJob("sendMsgShardingHandler")
    public void sendMsgShardingHandler() throws Exception{
        System.out.println("任务开始时间:"+new Date());
        int shardTotal = XxlJobHelper.getShardTotal();
        int shardIndex = XxlJobHelper.getShardIndex();
        List<UserMobilePlan> userMobilePlans = null;
        if(shardTotal==1){
            //如果没有分片就直接查询所有数据
            userMobilePlans = userMobilePlanMapper.selectAll();
        }else{
            userMobilePlans = userMobilePlanMapper.selectByMod(shardIndex,shardTotal);
        }
        System.out.println("处理任务数量:"+userMobilePlans.size());
        Long startTime = System.currentTimeMillis();
        userMobilePlans.forEach(item->{
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("任务结束时间:"+new Date());
        System.out.println("任务耗时:"+(System.currentTimeMillis()-startTime)+"毫秒");
    }
}
