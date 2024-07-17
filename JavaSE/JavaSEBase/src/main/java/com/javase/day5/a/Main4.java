package com.javase.day5.a;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 泛型方法
 * @author lixuan
 * @Date 2024/6/17 15:07
 */
public class Main4 {
    public static void main(String[] args) {
        String str = test("Hello World!");
        System.out.println(str);

        Integer[] arr = {1, 4, 5, 2, 6, 3, 0, 7, 9, 8};
        Arrays.sort(arr, new Comparator<Integer>() {
            //通过创建泛型接口的匿名内部类，来自定义排序规则，因为匿名内部类就是接口的实现类，所以说这里就明确了类型
            @Override
            public int compare(Integer o1, Integer o2) {   //这个方法会在执行排序时被调用（别人来调用我们的实现）
                //compare方法要求返回一个int来表示两个数的大小关系，大于0表示大于，小于0表示小于
                //这里直接o2-o1就行，如果o2比o1大，那么肯定应该排在前面，所以说返回正数表示大于
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
        //瞬间变一行，效果跟上面是一样的
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 泛型方法会在使用时自动确定泛型类型，比如我们定义的是类型T作为参数，同样类型的T作为返回值，实际上传入的参数是一个字符串类型的值，
     * 那么T就会zi'di'don
     */
    private static <T> T test(T t){   //在返回值类型前添加<>并填写泛型变量表示这个是一个泛型方法
        return t;
    }
}
