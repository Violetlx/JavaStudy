package com.lambda.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 01-统计分析
 * @author lixuan
 * @Date 2024/7/26 10:53
 */
public class Main1 {

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

    private static final String DATA_FILE = "JavaSkill/Lambda/src/main/resources/document/data.txt";

    public static void main(String[] args) {
        //1、统计每月销量
        test1(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test2(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test3(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test4(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test5(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test6(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test7(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test8(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test9(Path.of(DATA_FILE));

        System.out.println("------------------------");

        test10(Path.of(DATA_FILE));
    }

    /**
     * 1、统计每月的销量
     */
    private static void test1(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<TemporalAccessor, Long> collect = lines.skip(1)
//                    .limit(5)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> YearMonth.from(FORMATTER.parse(array[TIME])), TreeMap::new,Collectors.counting()));

            collect.forEach((key, value) -> System.out.println(key + " 订单数" + value));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 2、销量最高
     */
    private static void test2(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<TemporalAccessor, Long> collect = lines.skip(1)
//                    .limit(5)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> YearMonth.from(FORMATTER.parse(array[TIME])),Collectors.counting()));

//            collect.forEach((key, value) -> System.out.println(key + " 订单数" + value));

            collect.entrySet()
                    .stream()
//                    .max(Comparator.comparingLong(Map.Entry::getValue))
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(line-> System.out.println("销量最高的月份：" + line.getKey() + " 订单数" + line.getValue()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 3、求销量最高的商品
     */
    private static void test3(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> array[PRODUCT_ID], Collectors.counting()));

            collect.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(line-> System.out.println("销量最高的商品：" + line.getKey() + " 订单数" + line.getValue()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 4、下单最多的前10用户
     */
    private static void test4(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> array[USER_ID], Collectors.counting()));

            collect.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .forEach(line-> System.out.println("下单最多的前10用户：" + line.getKey() + " 订单数" + line.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 5、每个地区下单最多的用户
     */
    private static void test5(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Map<String, Long>> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> array[USER_REGION],
                            Collectors.groupingBy(array -> array[USER_ID],
                                    Collectors.counting())));

            collect.entrySet()
                    .stream()
                    .map(e->Map.entry(e.getKey(),e.getValue().entrySet().stream().max(Map.Entry.comparingByValue())))
                    .forEach(e->{
                        if (e.getValue().isPresent()) {
                            System.out.println("地区：" + e.getKey() + " 下单最多的用户：" + e.getValue().get().getKey() + " 订单数" + e.getValue().get().getValue());
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 6、每个地区下单最多的前3用户
     */
    private static void test6(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Map<String, Long>> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(array -> array[USER_REGION],
                            Collectors.groupingBy(array -> array[USER_ID],
                                    Collectors.counting())));

            Stream<Map.Entry<String, List<Map.Entry<String, Long>>>> entryStream = collect.entrySet()
                    .stream()
                    .map(e -> Map.entry(e.getKey(), e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(3)
                            .toList()));
            entryStream.forEach(e -> {
                System.out.println("地区：" + e.getKey());
                e.getValue().forEach(line -> System.out.println("下单最多的前3用户：" + line.getKey() + " 订单数" + line.getValue()));
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 7、按类别统计销量
     */
    private static void test7(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(a -> !a[CATEGORY_CODE].isEmpty())
                    .collect(Collectors.groupingBy(array -> array[CATEGORY_CODE],
                            Collectors.counting()));
            collect.forEach((key, value) -> System.out.println("类别：" + key + " 订单数" + value));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 8、按一级类别统计销量
     */
    private static void test8(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            Map<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(a -> !a[CATEGORY_CODE].isEmpty())
                    .collect(Collectors.groupingBy(Main1::firstCategory, TreeMap::new, Collectors.counting()));

            collect.forEach((key, value) -> System.out.println("类别：" + key + " 订单数" + value));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String firstCategory(String[] a) {
        String category = a[CATEGORY_CODE];
        //找到第一个.的位置
        int dot = category.indexOf(".");
        //截取以及类别字符串
        return category.substring(0, dot);
    }

    /**
     * 9、按价格区间统计销量
     */
    private static void test9(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            TreeMap<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .map(array -> Double.parseDouble(array[PRICE]))
                    .collect(Collectors.groupingBy(Main1::priceRange, TreeMap::new, Collectors.counting()));

            collect.forEach((key, value) -> System.out.println("价格区间：" + key + " 订单数" + value));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String priceRange(Double price) {
        if (price < 100) {
            return "[0,100)";
        } else if (price >= 100 && price < 500) {
            return "[100,500)";
        } else if (price >= 500 && price < 1000) {
            return "[500,1000)";
        } else {
            return "[1000,∞)";
        }
    }

    /**
     * 10、不同年龄段女性所下不同类别订单
     */
    private static void test10(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            TreeMap<String, Long> collect = lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(array -> !array[CATEGORY_CODE].isEmpty())
                    .filter(array -> array[USER_SEX].equals("女"))
                    .collect(Collectors.groupingBy(Main1::ageRange, TreeMap::new, Collectors.counting()));

            collect.forEach((key, value) -> System.out.println("女性年龄区间：" + key + " 订单数" + value));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String ageRange(String[] array) {
        int age = Double.valueOf(array[USER_AGE]).intValue();
        if (age < 18) {
            return "[0,18)";
        } else if (age < 30) {
            return "[18,30)";
        } else if (age < 50) {
            return "[30,50)";
        } else {
            return "[50,∞)";
        }
    }
}
