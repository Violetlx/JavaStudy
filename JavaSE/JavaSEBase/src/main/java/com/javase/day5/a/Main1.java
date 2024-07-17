package com.javase.day5.a;

/**
 * 泛型
 * @author lixuan
 * @Date 2024/6/17 14:43
 */
public class Main1 {
    public static void main(String[] args) {
        Score score = new Score("张三","001",90);
        Score score1 = new Score("李四","002",80);
        System.out.println(score);
        System.out.println(score1);

        //获取成绩需要进行强制类型转换，虽然并不是一开始的类型，但是编译不会报错
        Integer number = (Integer) score.getValue();
        System.out.println(number);

        /**
         * 使用Object类型作为引用，对于使用者来说，由于是Object类型，所以说并不能直接判断存储的类型到底是String还是Integer，
         * 取值只能进行强制类型转换，显然无法在编译期确定类型是否安全，项目中代码量非常之大，进行类型比较又会导致额外的开销和增加
         * 代码量，如果不经比较就很容易出现类型转换异常，代码的健壮性有所欠缺
         */
    }
}
