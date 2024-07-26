package com.lambda.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 异步CompletableFuture
 * @author lixuan
 * @Date 2024/7/26 15:01
 */
public class Main3 {
    /**
     * 序号
     */
    static final int INDEX = 0;
    /**
     * 下单时间
     */
    static final int TIME = 1;
    /**
     * 订单编号
     */
    static final int ORDER_ID = 2;
    /**
     * 商品编号
     */
    static final int PRODUCT_ID = 3;
    /**
     * 类别编号
     */
    static final int CATEGORY_ID = 4;
    /**
     * 类别码
     */
    static final int CATEGORY_CODE = 5;
    /**
     * 品牌
     */
    static final int BRAND = 6;
    /**
     * 价格
     */
    static final int PRICE = 7;
    /**
     * 用户编号
     */
    static final int USER_ID = 8;
    /**
     * 用户年龄
     */
    static final int USER_AGE = 9;
    /**
     * 用户性别
     */
    static final int USER_SEX = 10;
    /**
     * 用户地区
     */
    static final int USER_REGION = 11;


    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    static Logger logger = Logger.getLogger("Main3");

    public static void main(String[] args) throws Exception {
        // 1) 异步执行任务
//        CompletableFuture.runAsync()                 //在任务不需要返回结果时
//        CompletableFuture.supplyAsync()              //在任务需要处理结果时

        //这个类里面是守护线程
        CompletableFuture.runAsync(()-> logger.info("异步操作"));
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            logger.info("异步操作");
            return "结果";
        });
        System.out.println(supplyAsync.get());

        //不让主线程立刻结束
//        System.in.read();

        // 2) 处理异步任务结果
        /*
            thenApply()                  转换结果
            thenApplyAsync()             异步转换结果
            thenAccept(Consumer)         消费结果
            thenAcceptAsync(Consumer)    异步消费结果
         */

        supplyAsync.thenApply(s -> "thenApply===>"+ s + " 转换结果").thenAccept(s -> logger.info(s));
        supplyAsync.thenApplyAsync(s -> "thenApplyAsync===>"+s + " 异步转换结果").thenAccept(s -> logger.info(s));
        supplyAsync.thenAccept(s -> logger.info("thenAccept===>"+s));
        supplyAsync.thenAcceptAsync(s -> logger.info("thenAcceptAsync===>"+s));

        System.out.println("---------------------------------------------");

        logger.info("开始统计");
        // 异步执行
        CompletableFuture
                .supplyAsync(Main3::monthlySalesReport)
                .thenAccept(map -> map.entrySet().forEach(e -> logger.info(e.toString())));
        logger.info("执行其它操作");

        //不让线程立刻结束
        Thread.sleep(10000);
    }

    private static Map<YearMonth, Long> monthlySalesReport() {
        try (Stream<String> lines = Files.lines(Path.of("JavaSkill/Lambda/src/main/resources/document/data.txt"))) {
            return lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> YearMonth.from(FORMATTER.parse(array[TIME])), TreeMap::new, Collectors.counting()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
