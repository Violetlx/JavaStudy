package com.lambda.day3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Stream-效率
 * @author lixuan
 * @Date 2024/7/25 15:50
 */
public class Main17 {

    /*
     * 做数值计算，优先挑选基本流（IntStream 等）在数据量较大时，它的性能已经非常接近普通 for 循环
     * 做数值计算，应当避免普通流（Stream）性能与其它几种相比，慢一个数量级
     */

    @State(Scope.Benchmark)
    public static class MyState {
        public static final int COUNT = 1000;

        public int[] numbers = new int[COUNT];

        public List<Integer> numberList = new ArrayList<>(COUNT);

        public MyState() {
            for (int i = 0; i < COUNT; i++) {
                int x = i + 1;
                numbers[i] = x;
                numberList.add(i,x);
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int primitive(MyState state) {
        int sum = 0;
        for (int number : state.numbers) {
            sum += number;
        }
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int boxed(MyState state) {
        int sum = 0;
        for (Integer number : state.numbers) { //拆箱
            sum += number;
        }
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int stream(MyState state) {
        return state.numberList.stream().reduce(0, Integer::sum);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int intStream(MyState state) {
        return IntStream.of(state.numbers).sum();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main17.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();


    }
}
