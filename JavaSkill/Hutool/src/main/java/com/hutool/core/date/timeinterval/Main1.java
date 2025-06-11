package com.hutool.core.date.timeinterval;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;

/**
 * TimeInterval分组计时
 * @author lixuan
 * @Date 2024/12/20 9:24
 */
public class Main1 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1.计时
     */
    private static void test1(){
        TimeInterval timer = DateUtil.timer();

        //---------------------------------
        //-------这是执行过程
        //---------------------------------
        ThreadUtil.sleep(800);

        //花费毫秒数
        long interval = timer.interval();
        System.out.println("花费毫秒数：" + interval);
        //返回花费时间，并重置开始时间
        long l = timer.intervalRestart();
        System.out.println("返回花费时间，并重置开始时间：" + l);
        //花费分钟数
        long l1 = timer.intervalMinute();
        System.out.println("花费分钟数：" + l1);
    }

    /**
     * 2.分组计时
     */
    private static void test2(){
        final TimeInterval timer = new TimeInterval();

        // 分组1
        timer.start("1");
        ThreadUtil.sleep(800);

        // 分组2
        timer.start("2");
        ThreadUtil.sleep(900);

        Console.log("Timer 1 took {} ms", timer.intervalMs("1"));
        Console.log("Timer 2 took {} ms", timer.intervalMs("2"));

    }
}
