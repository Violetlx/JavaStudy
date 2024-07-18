## 2 Lambda表达式

### 2.1 概述

​     Lambda表达式是JDK8中的一个语法糖。它可以对某些匿名内部类的写法进行简化。它是函数式编程思想的一个重要体现。让我们不用关注什么对象。而是更关注我们对数据进行了什么操作。

### 2.2 核心原则

​    可推到可省略

### 2.3 基本格式

```java
(参数列表) -> {代码}
```

#### 例一：

我们在创建线程并启动时可以使用匿名内部类的写法:

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("你知道吗 我比你想象的 更想在你身边");
    }
}).start();
```

可以使用Lambda表达式的格式对其进行修改。修改后如下:

```java
new Thread(()->{
    System.out.println("你知道吗 我比你想象的 更想在你身边");
})
```

```java
/**
 * 1、Lambda表达式入门
 */
@Test
void Lambda1() {
    //匿名内部类的写法
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("新线程中方法被执行了");
        }
    }).start();//启动线程

    //简化 如果匿名内部类是一个接口并且当中只有一个抽象方法需要重写,那么就可以对其简化
    new Thread(() -> System.out.println("Hello World!")).start();
}
```

#### 例二：

现有方法定义如下,其中IntBinaryOperator是一个接口。先使用匿名内部类的写法调用该方法

```java
/**
 * 2、Lambda表达式的使用
 */
@Test
void Lambda2(){
    //方法调用
    int num = calculateNum(new IntBinaryOperator() {//传入匿名内部类对象
        //所以调用的实际上是匿名内部类的方法
        @Override
        public int applyAsInt(int left, int right) {
            return left + right;
        }
    });
    System.out.println("num==="+num);

    //优化成Lambda表达式
    int i = calculateNum((right, left) -> {//重写方法的参数列表
        return left + right;//重写方法的方法体
    });
    System.out.println("i==="+i);

    //匿名内部类和Lambda表达式可以使用Alter+回车进行快速转换
}

public static int calculateNum(IntBinaryOperator operator){
    int a=10;
    int b=20;
    return operator.applyAsInt(a,b);
}
```

关键词 Alter+回车  可以快捷把能够转化的匿名内部类转换成Lambda表达式  也可以Alter+回车 转换回匿名内部类

#### 例三：

现有方法定义如下,其中IntPredicate是一个接口。先使用匿名内部类的写法调用该方法。

```java
/**
 * 3、Lambda表达式的使用
 */
@Test
void Lambda3() {
    //强调,函数式变成里面不要去关注方法名是什么,类名是什么,而应该关注数据
    //重写匿名内部类  要求,找出偶数
    printNum(new IntPredicate() {
        @Override
        public boolean test(int value) {
            if (value % 2 == 0) {
                return true;
            }
            return false;
        }
    });

    System.out.println("----------------------");

    //Lambda表达式优化 要求,找出偶数
    printNum(value -> value % 2 == 0);

    System.out.println("----------------------");

    //Lambda表达式优化 要求,找出奇数
    printNum(value -> value % 2!= 0);

}

public static void printNum(IntPredicate predicate){
    int[] arr={1,2,3,4,5,6,7,8,9,10};
    for (int i:arr) {
        if (predicate.test(i)) {//test是predicate里面的抽象方法
            System.out.println(i);
        }
    }
}
```

**注释**:函数式编程关注的是具体的参数列表和方法体

#### 例四：

现有方法定义如下,其中Function是一个接口,先使用匿名内部类的写法调用该方法

```java
/**
 * 4、Lambda表达式的使用
 */
@Test
void Lambda4() {
    //匿名内部类的格式    输出字符串的长度        这里需要去确定泛型是什么？
    typeConver(new Function<String, Integer>() {
        //关注参数 方法体 返回值
        @Override
        public Integer apply(String s) {//参数值类型为第一个泛型的类型
            if (s.length() > 0) {
                System.out.println(s.length());
                return s.length();//返回值的类型为第二个泛型的类型
            }
            System.out.println("null");
            return null;
        }
    });

    System.out.println("----------------------");
    
    typeConver(new Function<String, String>() {
        @Override
        public String apply(String s) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s);
            stringBuffer.append("旋");
            System.out.println(stringBuffer);
            return stringBuffer.toString();
        }
    
    System.out.println("----------------------");
        
    //转换为byte数组
    byte[] bytes = typeConver(str -> str.getBytes());
    for (byte aByte : bytes) {
        System.out.println(aByte);
    }

    System.out.println("----------------------");

    //转换为小写
    String s = typeConver(str -> str.toLowerCase());
    System.out.println(s);

    System.out.println("----------------------");

    //转换为大写
    String s1 = typeConver(str -> str.toUpperCase());
    System.out.println(s1);

}

/*泛型*/
public static<R> R typeConver(Function<String,R> function){
    String str="1235helLOl";
    R result=function.apply(str);
    return result;
}
```

#### 例五：

现有方法定义如下,其中IntConsumer是一个接口,先使用匿名内部类的写法调用该方法。

```java
/**
 * 5、Lambda表达式的使用
 */
@Test
void Lambda5() {
    //匿名内部类    遍历数组元素
    foreachArr(new IntConsumer() {
        @Override
        public void accept(int value) {
            System.out.println(value);
        }
    });

    System.out.println("----------------------");

    //Lambda表达式优化
    foreachArr(value -> System.out.println(value));
}

public static void foreachArr(IntConsumer consumer){
    int[] arr={1,2,3,4,5,6,7,8,9,10};
    for (int i:arr) {
        consumer.accept(i);
    }
}
```

补充:Lambda表达式其实就是对匿名内部类的优化



### 2.4 省略规则

-   参数类型可以省略
- 方法体只有一句代码时大括号return和唯一句代码的分号可以省略
- 方法只有一个参数时小括号可以省略
- 以上这些规则记不住也可以省略不记 

```java
@Test
void Lambda5() {
    //匿名内部类    遍历数组元素
    foreachArr(new IntConsumer() {
        @Override
        public void accept(int value) {
            System.out.println(value);
        }
    });

    System.out.println("----------------------");

    //Lambda表达式优化
    foreachArr(value -> System.out.println(value));
}

public static void foreachArr(IntConsumer consumer){
    int[] arr={1,2,3,4,5,6,7,8,9,10};
    for (int i:arr) {
        consumer.accept(i);
    }
}
```