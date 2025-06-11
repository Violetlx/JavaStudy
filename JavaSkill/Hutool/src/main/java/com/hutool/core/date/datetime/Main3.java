package com.hutool.core.date.datetime;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;

/**
 * 对象的可变性
 * @author lixuan
 * @Date 2024/12/19 15:27
 */
public class Main3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 1.对象的可变性
     */
    public static void test1(){
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);

        //默认情况下DateTime为可变对象，此时offset == dateTime
        DateTime offset = dateTime.offset(DateField.YEAR, 0);
        System.out.println("test1--offset==>"+offset);

        boolean equals1 = offset==dateTime;
        System.out.println("test1--equals1==>"+equals1);

        //设置为不可变对象后变动将返回新对象，此时offset != dateTime
        dateTime.setMutable(false);
        offset = dateTime.offset(DateField.YEAR, 0);
        System.out.println("test1--offset==>"+offset);

        // 判断offset是否等于dateTime
        boolean equals = offset==dateTime;
        System.out.println("test1--equals==>"+equals);
    }
}
