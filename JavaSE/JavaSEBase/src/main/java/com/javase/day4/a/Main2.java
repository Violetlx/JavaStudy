package com.javase.day4.a;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * 特殊包装类
 * @author lixuan
 * @Date 2024/6/12 12:19
 */
public class Main2 {
    public static void main(String[] args) {
        /**
         * 两个比较特殊的包装类型
         */

        /**
         * ① BigInteger
         * 我们知道，即使是最大的long类型，也只能表示64bit的数据，无法表示一个非常大的数，但是BigInteger没有限制，可以表示任意大的数。
         */
        //表示Long的最大值
        BigInteger b1 = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(b1);

        //表示Long的最大值加1
        BigInteger b2 = b1.add(BigInteger.valueOf(1));
        System.out.println(b2);

        //即使是long的最大值乘以long的最大值，也能给你算出来
        BigInteger b3 = b1.multiply(BigInteger.valueOf(Long.MAX_VALUE));
        System.out.println(b3);

        //来个更刺激的 Long的最大值的100次方，也是轻轻松松
        BigInteger b4 = b1.pow(100);
        System.out.println(b4);

        //一般来说，对于非常大的整数计算，我们就可以使用BigInteger来完成

        System.out.println("------------------------------------");


        /**
         * ② BigDecimal
         * 前面我们说了，浮点数有精度限制，对于需要精确计算的场景，就没办法了，而BigDecimal就没有这个问题，可以实现小数的精确计算。
         */
        BigDecimal i1 = BigDecimal.valueOf(10);
        BigDecimal i2 = i1.divide(BigDecimal.valueOf(3), 100, RoundingMode.CEILING);
        //计算10/3的结果，精确到小数点后100位
        //RoundingMode是舍入模式，就是精确到最后一位时，该怎么处理，这里的CEILING表示向上取整
        System.out.println(i2);

        //但是注意，对于这种结果是没有终点的，无限循环的小数，我们必须要限制长度，否则会出现异常。

    }
}
