package com.javase.day5.b;

/**
 * 顺序表
 * @author lixuan
 * @Date 2024/6/25 17:21
 */
public class ArrayList<E> {   //泛型E，因为表中要存的具体数据类型待定
    //当前顺序表的容量
    int capacity = 10;
    //当前已经存放的元素数量
    int size = 0;
    //底层存放数据的数组
    private Object[] array = new Object[capacity];

    /**
     * 插入元素
     */

    //当插入元素时，需要将插入位置给腾出来，也就是将后面的元素向后移
    //同样的，如果要删除元素，那么也需要将所有元素向前移动
    //顺序表是紧凑的，中间不能出现空位。

/*
    public void add(E element, int index){   //插入方法需要支持在指定下标位置插入
        for (int i = size; i > index; i--)   //从后往前，一个一个搬运元素
            array[i] = array[i - 1];
        array[index] = element;   //腾出位置之后，直接插入元素放到对应位置上
        size++;   //插入完成之后，记得将size自增
    }
*/

    //只不过这样并不完美，因为我们的插入操作并不是在任何位置都支持插入的，我们允许插入的位置智能是[0,size]这个范围内
    //所以说我们在插入之前需要进行判断

/*
    public void add(E element, int index){
        if (index < 0 || index > size)  //如果插入位置不合法，那么直接抛出异常
            throw new IndexOutOfBoundsException("插入位置不合法,合法的插入位置为[0,size]");
        for (int i = size; i > index; i--)   //从后往前，一个一个搬运元素
            array[i] = array[i - 1];
        array[index] = element;   //腾出位置之后，直接插入元素放到对应位置上
        size++;   //插入完成之后，记得将size自增
    }
*/

    //只不过依然不完美，万一我们的顺序表装满了咋办？所以说，我们在插入元素之前，需要进行判断，如果已经满了，那么我们需要先扩容之后才能继续插入新的元素

    public void add(E element, int index){
        //先判断插入位置合法性
        if (index<0|| index>size) {
            throw new IndexOutOfBoundsException("插入位置不合法,合法的插入位置为[0,size]");
        }

        //再判断顺序表是否已经装满
        if (capacity == size) { //装满了
            //那就进行扩容
            int newCapacity = capacity + (capacity >> 1); //扩容规则就按照原来的1.5倍来
            //创建一个扩容后的新数组来接收元素
            Object[] newArray = new Object[newCapacity];
            //使用arraycopy快速拷贝原数组内容到新的数组
            System.arraycopy(array, 0, newArray, 0, size);
            //替换为新数组
            array=newArray;
            //容量变为扩容后的
            capacity = newCapacity;
        }
        //给插入元素腾出位置
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        //插入
        array[index] = element;
        size++;
    }


    /**
     * 删除操作
     */


/*
    @SuppressWarnings("unchecked")   //屏蔽未经检查警告
    public E remove(int index){ //删除对应位置上的元素，注意需要返回被删除的元素
        //因为存放的是Object类型，这里需要强制类型转换为E
        E e = (E) array[index];
        //从前往后，挨个往前搬一位
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        //删完记得size--
        size--;
        return e;
    }
*/

    //同样的，删除操作也需要判断，如果删除位置不合法，那么直接抛出异常

    @SuppressWarnings("unchecked")
    public E remove(int index) { //删除操作不需要考虑容量问题
        //可删除的区间为[0,size)这个半闭半开区间
        if (index <0 || index > size-1 ) {
            throw new IndexOutOfBoundsException("删除位置不合法,合法的删除位置为[0,size-1]");
        }
        E e = (E) array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return e;
    }

    //Get方法,根据指定下标获取对应元素
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("获取位置不合法,合法的获取位置为[0,size-1)");
        }
        return (E) array[index];
    }

    //获取size
    public int size(){
        return size;
    }




    /**
     * toString打印元素
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
