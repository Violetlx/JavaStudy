package com.javase.day5.b;

/**
 * 线性表：顺序表
 * @author lixuan
 * @Date 2024/6/25 17:11
 */
public class Main1 {
    //线性表是由同一类型的数据元素构成的有序序列的线性结构。线性表中元素的个数就是先行表的长度，表的起始位置叫表头，表的结束位置叫表尾
    //当一个线性表中没有元素时，称为空表
    public static void main(String[] args) {
        //顺序表，采用顺序存储实现的线性表，我们称为顺序表

        //测试插入方法
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(10,1);  //一上来只能在第一个位置插入，插在第二个位置肯定是非法的
        for (int i = 0; i <= 20; i++) {
            list.add(i*10, i);
        }
        String add = list.toString();
        System.out.println("add ===> "+add);
        //可以看到顺序表在自动扩容

        //删除方法
        Integer remove = list.remove(20);
        System.out.println("remove ===> "+remove);

        //获取对应下标
        Integer get = list.get(10);
        System.out.println("get ===> "+get);

        //获取顺序表元素个数
        int size = list.size();
        System.out.println("size ===> "+size);

    }
}
