package com.lambda.day2.c;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

/**
 * 16-高阶函数-简单流
 * @author lixuan
 * @Date 2024/7/19 10:10
 */
public class Main3<T> {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Main3.of(list)
                .filter(x -> (x & 1) == 1)
                .map(x -> x * x)
                .forEach(System.out::println);

        System.out.println("求和===>"+Main3.of(list).reduce(0, Integer::sum));
        System.out.println("最小值===>"+Main3.of(list).reduce(Integer.MAX_VALUE, Math::min));
        System.out.println("最大值===>"+Main3.of(list).reduce(Integer.MIN_VALUE, Math::max));

        //收集
        HashSet<Integer> collect = Main3.of(list)
                .filter(x -> (x & 1) == 1)
                .collect(HashSet::new, (set, t) -> set.add(t));
        System.out.println("收集===>"+collect);

        //字符串拼接
        StringBuilder stringBuilder = Main3.of(list)
                .filter(x -> (x & 1) == 1)
                .map(x -> x * x)
                .collect(StringBuilder::new, (sb, t) -> sb.append(t).append(","));
        System.out.println("字符串拼接===>"+stringBuilder);

        //收集
        HashMap<Object, Object> hashMap = Main3.of(list)
                .filter(x -> (x & 1) == 1)
                .map(x -> x * x)
                .collect(HashMap::new, (map, t) -> map.put(t, t*t));
        System.out.println("收集===>"+hashMap);

        List<Integer> list1 = List.of(1,2,1,2,1,4,5,5,3,3);

        HashMap<Integer, Integer> hashMap1 = Main3.of(list1)
                .collect(HashMap::new, (map, t) -> {
                    if (!map.containsKey(t)) {
                        map.put(t, 1);
                    } else {
                        Integer v =  map.get(t);
                        map.put(t, v + 1);
                    }
                });
        System.out.println("收集1===>"+hashMap1);


        /*
           如果 key 在 map 中不存在，将 key 连同新生成的 value 值存入 map,并返回 value
           如果 key 在 map 中存在，会返回此 key 上次的 value 值
         */
        HashMap<Integer, AtomicInteger> hashMap2 = Main3.of(list1)
                .collect(HashMap::new, (map,t)->map.computeIfAbsent(t,k-> new AtomicInteger()).getAndIncrement());
        System.out.println("收集2===>"+hashMap2);
    }

    /*
         简单流-收集
         提供一个新的容器(集合),将元素加入其中
         收集规则：
         1、用Set收集
         2、用StringBuilder收集
         3、用Map收集

         public interface BiConsumer<T, U> {
             void accept(C c,T t);
         }
     */

    //C代表容器类型

    public <C> C collect(Supplier<C> supplier, BiConsumer<C, T> consumer) {
        //创建了容器
        C c = supplier.get();
        for (T t : collection) {
            //向容器中添加元素
            consumer.accept(c, t);
        }
        return c;
    }

    /*
         简单流-化简
         两个元素,按照某种规则合并为一个
         合并规则：
         1、两个元素里挑小的
         2、两个元素里挑大的
         3、两个元素相加
     */

    public T reduce(T o,BinaryOperator<T> operator) {
        //上次合并的结果
        T p = o;
        //t 是本次遍历的元素
        for (T t : collection) {
            p = operator.apply(p, t);
        }
        return p;
    }


    /**
     * 过滤器
     * @param predicate Predicate<T>
     * @return Main3<T>
     */
    public Main3<T> filter(Predicate<T> predicate) {
        //先创建集合用来保存结果
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return new Main3<>(result);
    }

    /**
     * 转换对象
     * @param function Function<T, U>
     * @return Main3<U>
     */
    public <U> Main3<U> map(Function<T, U> function) {
        List<U> result = new ArrayList<>();
        for (T t : collection) {
            result.add(function.apply(t));
        }
        return new Main3<>(result);
    }

    /**
     * 遍历
     * @param consumer
     */
    public void forEach(Consumer<T> consumer) {
        for (T t : collection) {
            consumer.accept(t);
        }
    }

    public static <T> Main3<T> of(Collection<T> collection) {
        return new Main3<>(collection);
    }

    private Collection<T> collection;

    private Main3(Collection<T> collection) {
        this.collection = collection;
    }

}
