package com.javase.day5.b;



/**
 * 链表
 * @author lixuan
 * @Date 2024/6/28 9:37
 */
public class LinkedList<E> {
    //链表的头结点，用于连接之后的所有结点
    private final Node<E> head = new Node<>(null);
    //当前的元素数量还是要存一下，方便后面操作
    private int size = 0;

    private static class Node<E> {  //结点类，仅供内部使用
        //每个结点都存放元素
        //以及指向下一个结点的引用
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    //链表的插入

    //比如现在我们想插入到第二个位置来
    //我们可以先修改新插入结点的后继结点(也就是下一个结点)的指向，指向原本在这个位置的结点
    //接着我们可以将前驱结点(也就是上一个结点)的后继结点指向修改为我们新插入的结点
    //这样我们就成功插入了一个新的结点，现在新插入的结点到达了原本的第二个位置上

/*
    public void add(E element, int index) {
        //先找到对应位置的前驱结点
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //创建新的结点
        Node<E> node = new Node<>(element);
        //先让新的结点指向原本在这个位置上的结点
        node.next = prev.next;
        //再让前驱结点指向当前结点
        prev.next = node;
        //完事之后，更新size
        size++;
    }
*/

    //只不过还不完美，跟之前一样，我们还得考虑插入位置是否合法
    public void add (E element, int index) {
        //判断插入位置的合法性
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置是非合法的，合法的插入位置为：0~" + size);
        }
        //在找到对应位置的前驱结点
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node<E> node = new Node<>(element);
        node.next=prev.next;
        prev.next=node;
        size++;
    }

    //删除操作

    //我们可以直接将待删除结点的前驱结点指向修改为删除结点的下一个
    //这样，在逻辑上来说，待删除结点其实已经不在链表中了，所以我们只需要释放掉待删除结点占用的内存空间就行了

    public E remove(int index) {
        //判断位置是否合法
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("删除位置是非合法的，合法的删除位置为：0~" + (size - 1));
        }
        Node<E> prev = head;
        //同样需要先找到前驱结点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //先把待删除结点存放的元素取出来
        E e = prev.next.element;
        //可以删了
        prev.next = prev.next.next;
        size--;
        return e;
    }

    //根据下标获取元素
    public E get(int index) {
        //判断位置是否合法
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("获取位置是非合法的，合法的获取位置为：0~" + (size - 1));
        }
        Node<E> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    //获取元素个数
    public int size() {
        return size;
    }


    /**
     * toString方法
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> cur = head.next;
        while (cur != null) {
            sb.append(cur.element);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }



}
