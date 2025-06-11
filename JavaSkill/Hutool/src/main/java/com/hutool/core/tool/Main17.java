package com.hutool.core.tool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 随机工具-RandomUtil
 * @author lixuan
 * @Date 2025/1/9 10:57
 */
public class Main17 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * RandomUtil使用
     */
    public static void test1() {
        //RandomUtil.randomInt
        int randomInt = RandomUtil.randomInt();
        System.out.println("test1--randomInt==>"+randomInt);
        //最大
        int randomInt1 = RandomUtil.randomInt(100);
        System.out.println("test1--randomInt1==>"+randomInt1);
        //最大最小
        int randomInt2 = RandomUtil.randomInt(10, 100);
        System.out.println("test1--randomInt2==>"+randomInt2);

        //RandomUtil.randomInts 随机排列[0,10)
        int[] ints = RandomUtil.randomInts(10);
        System.out.println("test1--ints==>"+Arrays.toString(ints));

        //RandomUtil.randomBytes 随机 bytes，一般用于密码或者 salt 生成
        byte[] bytes = RandomUtil.randomBytes(10);
        System.out.println("test1--bytes==>"+Arrays.toString(bytes));

        //RandomUtil.randomEle 随机获得列表中的元素
        String randomEle = RandomUtil.randomEle(new String[]{"a", "b", "c"});
        System.out.println("test1--randomEle==>"+randomEle);

        //RandomUtil.randomEleSet 随机获得列表中的一定量的不重复元素，返回 LinkedHashSet
        Set<Integer> set = RandomUtil.randomEleSet(
                CollUtil.newArrayList(1,1,2,2,3,3,4,4,5,5,6,6,6,6,6,6,6),2);
        System.out.println("test1--set==>"+set);

        //RandomUtil.randomNumbers 获得一个只包含数字的字符串
        String randomNumbers = RandomUtil.randomNumbers(10);
        System.out.println("test1--randomNumbers==>"+randomNumbers);

        //RandomUtil.weightRandom 权重随机生成器，传入带权重的对象，
        //然后根据权重随机获取对象(权重只是概率比较大，不是百分百)
        WeightRandom.WeightObj<String>[] weightObjs = new WeightRandom.WeightObj[3];
        weightObjs[0] = new WeightRandom.WeightObj<>("A", 10);
        weightObjs[1] = new WeightRandom.WeightObj<>("B", 30);
        weightObjs[2] = new WeightRandom.WeightObj<>("C", 60);
        // 根据权重随机获取一个对象
        WeightRandom<String> stringWeightRandom = RandomUtil.weightRandom(weightObjs);

        // 输出结果
        System.out.println("随机获取的对象是: " + stringWeightRandom.next());
    }
}
