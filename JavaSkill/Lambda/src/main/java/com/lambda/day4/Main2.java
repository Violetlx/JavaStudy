package com.lambda.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 异步处理
 * @author lixuan
 * @Date 2024/7/26 14:34
 */
public class Main2 {

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

    static Logger logger = Logger.getLogger("Main2");

    public static void main(String[] args) {

        logger.info("开始统计");
//        monthlySalesReport(s->s.forEach((k,v)->logger.info(k+"月销售数量："+v)));

        //异步处理
//        new Thread(()->monthlySalesReport(s->s.forEach((k,v)->logger.info(k+"月销售数量："+v)))).start();

        //利用线程池
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(()->monthlySalesReport(s->s.forEach((k,v)->logger.info(k+"月销售数量："+v))));

        //使用异步处理其他不需要等待同步操作结束，是并行
        logger.info("执行其他操作");
        System.out.println("11111111111111");

        //关闭线程池
        service.shutdown();
    }

    private static void monthlySalesReport(Consumer<Map<YearMonth, Long>> consumer) {
        try (Stream<String> lines = Files.lines(Path.of("JavaSkill/Lambda/src/main/resources/document/data.txt"))) {
            Map<YearMonth, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> YearMonth.from(FORMATTER.parse(array[TIME])), TreeMap::new, Collectors.counting()));
            consumer.accept(collect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
