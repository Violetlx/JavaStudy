package com.algorithms;

import com.algorithms.day1.BinarySearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AlgorithmsApplicationTests {

    @Test
    @DisplayName("binarySearchBasic 找到")
    void test1() {
        int[] a = {7,13,21,30,38,44,52,53};
        assertEquals(0, BinarySearch.binarySearchBasic(a, 7));
        assertEquals(1, BinarySearch.binarySearchBasic(a, 13));
        assertEquals(2, BinarySearch.binarySearchBasic(a, 21));
        assertEquals(3, BinarySearch.binarySearchBasic(a, 30));
        assertEquals(4, BinarySearch.binarySearchBasic(a, 38));
        assertEquals(5, BinarySearch.binarySearchBasic(a, 44));
        assertEquals(6, BinarySearch.binarySearchBasic(a, 52));
        assertEquals(7, BinarySearch.binarySearchBasic(a, 53));
    }

    @Test
    @DisplayName("binarySearchBasic 未找到")
    void test2() {
        int[] a = {7,13,21,30,38,44,52,53};
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 0));
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 15));
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 60));
    }

    @Test
    void test3() {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;
        int m = (i + j) / 2;

        //System.out.println(m);
        i = m + 1;

        System.out.println(i);
        System.out.println(j);
        System.out.println(i+j);

        /*
            同一个二进制
         */

        m = (i + j) / 2;
        //System.out.println(m);
    }

}
