package com.javase.day5.b;

import java.util.ArrayList;

/**
 * 线性表：链表
 * @author lixuan
 * @Date 2024/6/25 17:12
 */
public class Main2 {
    public static void main(String[] args) {
        /**
         * 链表不同于顺序表，顺序表的底层采用数组作为存储容器，需要分配一块连续完整的内存空间进行使用，而链表则不需要，它通过一个指针来连接各个
         * 分散的结点，形成了一个链状的结构，每个结点存放一个元素，以及一个指向下一个结点的指针，通过这样一个一个相连，最后形成了链表。它不需要
         * 申请连续的空间，只需要按照顺序连接即可，虽然物理上可能不相邻，但是在逻辑上依然是每个元素相邻存放的，这样的结构叫链表(单链表)
         */
        LinkedList<String> list = new LinkedList<>();
        list.add("a", 0);
        list.add("b",1);
        list.add("c",2);
        System.out.println("add ===> "+list.toString());

        String remove = list.remove(1);
        System.out.println("remove ===> "+remove);
        System.out.println("after remove ===> "+list.toString());

        String get = list.get(1);
        System.out.println("get ===> "+get);

        int size = list.size();
        System.out.println("size ===> "+size);

        //问题：什么情况下使用顺序表，什么情况下使用链表呢？
        /*
        1、通过分析顺序表和链表的特性我们不难发现，链表在随机访问元素时，需要通过遍历来完成，而顺序表则利用数组的特性直接访问得到，所以当我们读取数据多于插入
        或是删除数据的情况下时，使用顺序表更好。
        2、而顺序表则在插入时就显得比较鸡肋了，因为需要移动后续元素，整个移动操作会浪费时间，而链表则不需要，只需要修改结点指向即可完成插入，所以在频繁出现
        插入或删除的情况下，使用链表会更好
         */

        //虽然单链表使用起来也比较方便，不过有一个问题就是，如果我们想要操作某一个结点，比如删除或是插入，那么由于单链表的性质，我们只能先去找到它的前驱结点，
        //才能进行。味蕾解决这种查找前驱结点非常麻烦的问题，我们可以让结点不仅保存指向后续节点的指针，同时也保存指向前驱结点的指针，这样我们无论在哪个结点，都
        //能够快速找到对应的前驱结点，就很方便了，这样的链表我们称为双向链表(双链表)
    }
}
