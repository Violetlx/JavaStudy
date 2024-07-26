package com.lambda.day3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Stream-生成
 * @author lixuan
 * @Date 2024/7/19 16:10
 */
public class Main6 {

    public static void main(String[] args) {
        //生成从0~9的数字
        //1、InStream.range(0,10) 含头不含尾
        StringBuilder stringBuilder = IntStream.range(0, 10)
                .collect(StringBuilder::new,
                        (sb, i) -> {
                            if (!sb.isEmpty()) {
                                sb.append(",");
                            }
                            sb.append(i);
                        },
                        StringBuilder::append);
        System.out.println(stringBuilder);

        //2、IntStream.rangeClosed(0,9) 含头含尾
        IntStream.rangeClosed(0,9).forEach(System.out::println);

        System.out.println("===============================================");

        //3、IntStream.iterate(0,i->i+1)  生成 1 3 5 7 9 ... 奇数序列
        IntStream.iterate(0,i->i+1).filter(i->i%2!=0).limit(10).forEach(System.out::println);

        System.out.println("===============================================");

        IntStream.iterate(1,x->x<=9,x->x+2).forEach(System.out::println);

        System.out.println("===============================================");

        //4、生成随机数的序列  随机生成100以内的5个数
        IntStream.generate(()-> ThreadLocalRandom.current().nextInt(100)).limit(5).forEach(System.out::println);

        System.out.println("===============================================");

        //5、利用ThreadLocalRandom 生成100以内的5个整数
        IntStream ints = ThreadLocalRandom.current().ints(5, 0, 100);
        ints.forEach(System.out::println);
    }
}
