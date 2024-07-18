## 3 Stream流

### 3.1 概述

​     Java的Stram使用的是函数式变成模式,如同它的名字一样,它可以被用来对集合或数组进行链状流式的操作。可以方便的让我们对集合或数组操作。



### 3.2 案例数据准备

```java
/**
 * 
 * @TableName author
 */
@TableName(value ="author")
@Data
public class Author implements Serializable {
    /**
     * 作者ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 作者名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 作者年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 作者简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 作者的书籍
     */
    @TableField(exist = false)
    private List<Book> books;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
```

```java
/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     * 书籍ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 书名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类
     */
    @TableField(value = "category")
    private String category;

    /**
     * 评分
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 简介
     */
    @TableField(value = "intro")
    private String intro;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
```

```mysql
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL COMMENT '作者ID',
  `name` varchar(255) NOT NULL COMMENT '作者名',
  `age` int(11) DEFAULT NULL COMMENT '作者年龄',
  `intro` varchar(255) DEFAULT NULL COMMENT '作者简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```mysql
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL COMMENT '书籍ID',
  `name` varchar(255) NOT NULL COMMENT '书名',
  `category` varchar(255) NOT NULL COMMENT '分类',
  `score` int(11) NOT NULL COMMENT '评分',
  `intro` varchar(255) NOT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```xml
<!--起步依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!--mybatis依赖-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.0</version>
</dependency>

<!--Mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.1</version>
</dependency>

<!--Mysql-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

```java
/**
 * 静态对象
 */
public static List<Author> getAuthors(){
    //数据初始化
    Author author=new Author(1L,"蒙多",33,"蒙多医生想去哪就去哪",null);
    Author author2=new Author(2L,"亚拉索",15,"狂风也追不上他的思考速度,疾风亦有归途",null);
    Author author3=new Author(3L,"易",14,"当我开启高原血统的时候,你拿什么抵挡",null);
    Author author4=new Author(3L,"易",14,"当我开启高原血统的时候,你拿什么抵挡",null);
    //书籍列表
    List<Book> books1=new ArrayList<>();
    List<Book> books2=new ArrayList<>();
    List<Book> books3=new ArrayList<>();
    
    books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
    books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述了再多终究还是失去"));
    
    books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"人说放盐,剑说真香,什么鬼啊,这不是恩子主场"));
    books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"人说放盐,剑说真香,什么鬼啊,这不是恩子主场"));
    books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难让他出于劣势地位"));
    
    books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者为什么要等高原血统"));
    books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家的碰撞会起到什么样的化学反应"));
    books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家的碰撞会起到什么样的化学反应"));
    
    author.setBooks(books1);
    author2.setBooks(books2);
    author2.setBooks(books3);
    author3.setBooks(books3);
    
    List<Author> authorList=new ArrayList<>(Arrays.asList(author,author2,author3,author4));
    
    return authorList;
    
}
```

### 3.3 快速入门

#### 3.3.1 需求

​     我们可以调用getAuthous()方法获取到作家的集合。现在需要打印所有年龄小于18的作家的名字,并且需要注意去重。

#### 3.3.2 实现

```java
    /**
     * 1、Stream流的使用
     */
    @Test
    void stream1() {
        //打印所有年龄小于18的作家的名字,并且要注意去重
        List<Author> authors = getAuthors();

        //匿名内部类
        authors
                .stream()
                .distinct()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        System.out.println("test");
                        return author.getAge()<18;
                    }
                })
               .forEach(new Consumer<Author>() {
                   @Override
                   public void accept(Author author) {
                       System.out.println(author.getName());
                   }
               });

        System.out.println("----------------------------------");

        //Lambda表达式优化
        authors
                .stream()//把集合转换为流
                .distinct()//先去除重复的作家
                .filter(author -> author.getAge()<18)//筛选年龄小于18的
                .forEach(author -> System.out.println(author.getName()));//遍历答应名字
    }
```



```java
stram流的操作流程包括
    1 创建流
    2 中间操作
    3 终结操作
    
    forEach()就是一个终结操作,你必须要有终结操作，前面的代码才会生效才会被调用到,如果你没有终结操作,那么前面的代码都不会被调用到
    例如:可以将forEach()给注释掉并且,将filter转为匿名内部类的形式,在test()方法里面去打印一下,检查方法有没有被执行到。再去运行
        代码可以发现test()方法并没有被调用到,但是如果加上终结操作forEach()并运行,就可以发现test方法有被调用到。这就是终结操作
        的作用。流的操作很想工程当中的流水线,可以把每一个中间操作看作是流水线上的一个个步骤,但是这个流水线想要动起来,必须要去依靠
        终结操作的调用。
```



### 3.4 常用操作

#### 3.4.1 创建流

单列集合:   集合对象.stream()

```java
//单列集合: 集合对象.stream()
List<Author> authors = getAuthors();
Stream<Author> stream = authors.stream();
```

数组:  Arrays.stream(数组)或者使用Stream.of来创建

```java
//数组: Arrays.stream(数组)或者使用Stream.of(数组)来创建
Integer[] arr={1,2,3,4,5,6,7,8,9,10};
Stream<Integer> stream1 = Arrays.stream(arr);
stream1.forEach(System.out::println);
Stream<Integer> stream2 = Stream.of(arr);
stream2.forEach(System.out::println);
```

双列集合: 转换成单列集合后再创建

```java
//双列集合: 转换成单列集合后再创建
Map<String,Integer> map=new HashMap<>();
map.put("蜡笔小新",6);
map.put("小黑子",17);
map.put("日向雏田",16);

Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
```





```java
    /**
     * 2、Stream流的使用
     */
    @Test
    void stream2() {
        //单列集合: 集合对象.stream()
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        stream.forEach(System.out::println);

        System.out.println("---------------------");

        //数组: Arrays.stream(数组)或者使用Stream.of(数组)来创建
        Integer[] arr={1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);
        System.out.println("---------------------");
        Stream<Integer> stream2 = Stream.of(arr);
        stream2.forEach(System.out::println);

        System.out.println("---------------------");

        //双列集合: 转换成单列集合后再创建
        Map<String,Integer> map=new HashMap<>();
        map.put("蜡笔小新",6);
        map.put("小黑子",17);
        map.put("日向雏田",16);

        Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
        stream3.forEach(System.out::println);
        System.out.println("-----------------------");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(map.entrySet());
        System.out.println("-----------------------");
        Stream<Map.Entry<String, Integer>> stream4 = entries.stream();
        stream4.forEach(System.out::println);
        System.out.println("-----------------------");
        /*stream4.filter(entry -> entry.getValue()>16).forEach(System.out::println);*/
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        //流已运行或关闭
    }

   //流是针对集合或者数组去进行操作的
```



#### 3.4.2 中间操作

##### filter

​      可以对流中的元素进行条件过滤，符合条件的才能继续留在流中。



例如：

​     打印所有姓名长度大于1的作家的名称

```java
/**
 * 3、Stream流的使用
 */
@Test
void stream3() {
    //打印所有姓名长度大于1的作家的名称
    List<Author> authors = getAuthors();
    authors
            .stream()
            .filter(new Predicate<Author>() {//把流中的每一个元素依次传入到Predicate中的test()方法进行筛选
                @Override
                public boolean test(Author author) {
                    return author.getName().length()>1;
                }
            }).forEach(author -> System.out.println(author.getName()));

    System.out.println("----------------------------------");

    authors
            .stream()
            .filter(author -> author.getName().length()>1)
            .forEach(author -> System.out.println(author.getName()));
}
```



##### map

​     可以把对流中的元素进行计算或转换。

例如:

​     打印所有作家的姓名

```java
/**
 * 4、Stream流的使用
 */
@Test
void stream4() {
    //打印所有作家的姓名
    List<Author> authors = getAuthors();
    //匿名内部类
    authors.stream()
           .distinct()
            //                    原类型      期望转换的类型
           .map(new Function<Author, String>() {//把流中的元素进行类型转换
               @Override
               public String apply(Author author) {
                   return author.getName();//把流中的元素转换为操作作家名
               }
           }).forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            });

    System.out.println("-------------------");

    //Lambda表达式优化
    authors.stream()
            .distinct()
            .map(author -> author.getName())
            //中间操作完了一定要去调用终结操作
            .forEach(System.out::println);

    System.out.println("-------------------");
    //参数名要求见名知意

    //进行相应的计算
    authors.stream()
            .distinct()
            .map(author -> author.getAge()) //经过这一波操作之后,实际上流里面都是Integer类型的数据
            .map(age -> age+10)//将年龄都上调10岁
            .forEach(System.out::println);

}
```



##### distinct

​    可以去除流中的重复元素



例如：

​    打印所有的作家的姓名，并且要求不能有重复的元素。

```java
/**
 * 5、Stream流的使用
 */
@Test
void stream5() {
    //打印所有的作家名称,要求其中不能有重复的元素
    List<Author> authors = getAuthors();
    authors.stream()
           .distinct()
           .map(author -> author.getName())
           .forEach(System.out::println);

    System.out.println("----------------------------------");

    authors.stream()
            .distinct()
            .forEach(author -> System.out.println(author.getName()));
}
```

##### 注意：distinct方法是依赖Object的equals方法来判断是否是相同对象。所以需要重写equals方法。且distinct位置不同,对数据的去重也不同,这主要取决于前面    是什么数据。



##### sorted

​     可以对流中的对象进行排序



例如：

​     对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。

```java
/**
 * 6、Stream流的使用
 */
@Test
void stream6() {
    // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .sorted(new Comparator<Author>() {
                @Override
                public int compare(Author o1, Author o2) {
                    return o2.getAge()-o1.getAge();
                }
            }).forEach(System.out::println);

    System.out.println("----------------------------------");

    authors.stream()
            .distinct()
            .sorted((o1, o2) -> o2.getAge()-o1.getAge())
            .forEach(System.out::println);

    System.out.println("----------------------------------");

    authors.stream()//转换为流
            .distinct()//去重
            .sorted(Comparator.comparing(Author::getAge).reversed())//排序
            .forEach(System.out::println);

    System.out.println("----------------------------------");

    authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
}
```



##### limit

​    可以设置流的最大长度，超出的部分将被抛弃。



例如：

​    对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家的姓名。

```java
/**
 * 7、Stream流的使用
 */
@Test
void stream7() {
    //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家的姓名。
    //可以使用limit对流的长度进行限制
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .sorted(Comparator.comparing(Author::getAge).reversed())
            .limit(2)
            .forEach(author -> System.out.println(author.getName()));
}
```



##### skip

​    跳过流中的n个元素，返回剩下的元素。



例如：

   打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。

```java
/**
 * 8、Stream流的使用
 */
@Test
void stream8() {
    //打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .sorted(Comparator.comparing(Author::getAge).reversed())
            .skip(1)
            .forEach(author -> System.out.println(author.getId()+","+author.getName()+","+author.getAge()));
}
```



##### flatMap

​     map只能把一个对象转换成另一个对象作为流中的元素，而flatMap可以把一个对象转换成多个对象中的元素。



例一：

​    打印所有书籍的名字，要求对重复的元素进行去重。

```java
/**
 * 9、Stream流的使用
 */
@Test
void stream9() {
    // 打印所有书籍的名字，要求对重复的元素进行去重。
    List<Author> authors = getAuthors();
    //PS,这个只是为了探寻map和flatMap的区别
    authors.stream()
            .map(author -> author.getBooks())
            .forEach(new Consumer<List<Book>>() {
                @Override        //这里发现,利用map获取的是List<Book> books的集合对象 不是我们想要的Book对象
                public void accept(List<Book> books) {
                    books.forEach(book -> System.out.println(book.getName()));
                }
            });

    System.out.println("------------------------------");

    authors.stream()
            .map(author -> author.getBooks())
            .flatMap(List::stream)
            .distinct()
            .forEach(book -> System.out.println(book.getName()));

    System.out.println("------------------------------");

    authors.stream()
            .flatMap(new Function<Author, Stream<Book>>() {
                @Override
                public Stream<Book> apply(Author author) {
                    return author.getBooks().stream();
                }
            })
            .distinct()
            .forEach(new Consumer<Book>() {
                @Override
                public void accept(Book book) {
                    System.out.println(book.getName());
                }
            });

    System.out.println("------------------------------");

    //Lambda表达式优化
    authors.stream()
           .flatMap(author -> author.getBooks().stream())//想要让流中的每个元素都变成book对象
           .distinct()
           .forEach(book -> System.out.println(book.getName()));
}
```



例二：

​    打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学、爱情

```java
/**
 * 10、Stream流的使用
 */
@Test
void stream10() {
    //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学、爱情
    List<Author> authors = getAuthors();
    authors.stream()
            .flatMap(author -> author.getBooks().stream())
            .distinct()//对流中的书籍进行去重
            .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
            .distinct()//对流中的书籍分类进行去重
            .forEach(category -> System.out.println(category));

    System.out.println("------------------------------");

    authors.stream()
            .flatMap(author -> author.getBooks().stream())
            .map(Book::getCategory)
            .distinct()
            .flatMap(category -> Arrays.stream(category.split(",")))
            .distinct()
            .forEach(System.out::println);
}
```

当我们需要把流中的一个元素转换成多个元素的时候，那么就可以使用到flatMap了



#### 3.4.3 终结操作

##### 注意：使用stream流的时候一定要使用终结操作来进行结尾，如果你没有使用终结操作，那么就相当于一条流水线上你没有去按开关一样，启动不了。

##### forEach

​     对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。



例子：

​    输出所有作家的名字。

```java
/**
 * 11、Stream流的使用
 */
@Test
void stream11() {
    // 输出所有作家的名字。
    List<Author> authors = getAuthors();

    authors.stream()
            .map(Author::getName)
            .distinct()
            .forEach(System.out::println);
}
```



##### count

​    可以用来获取当前流中元素的个数。



例子：

​    打印出这些作家的所有书籍的数目，注意删除重复元素。

```java
/**
 * 12、Stream流的使用
 */
@Test
void stream12() {
    //打印出这些作家的所有书籍的数目，注意删除重复元素。
    List<Author> authors = getAuthors();
    Long count = authors.stream()//首先先获取所有的作家
            .flatMap(author -> author.getBooks().stream())//再获取作家的所有书籍
            .distinct()//去重
            .count();//获取去重后的书籍的总数  需要主意接收他的返回值
    System.out.println(count);
}
```



##### max&min

​     可以用来求流中的最值



例子：

​    分别获取这些作家的所有书籍的最高分和最低分并打印。

```java
/**
 * 13、Stream流的使用
 */
@Test
void stream13() {
    //分别获取这些作家的所有书籍的最高分和最低分并打印。
    List<Author> authors = getAuthors();
    List<Book> bookList = authors.stream()
            .flatMap(author -> author.getBooks().stream())
            .distinct()
            .collect(Collectors.toList());
    Optional<Book> max = bookList.stream().max(Comparator.comparing(Book::getScore));
    System.out.println("最高分："+max.get().getScore());
    Optional<Book> min = bookList.stream().min(Comparator.comparing(Book::getScore));
    System.out.println("最低分："+min.get().getScore());

    System.out.println("------------------------");
    //Stream<Author> -> Stream<Book> -> Stream<Integer> -> 求值
    authors.stream()
           .flatMap(author -> author.getBooks().stream())
           .map(Book::getScore)
           .max(Integer::compareTo)
           .ifPresent(System.out::println);

    authors.stream()
            .flatMap(author -> author.getBooks().stream())
            .map(book -> book.getScore())
            .min(Integer::compareTo)
            .ifPresent(System.out::println);

    System.out.println("------------------------");

    authors.stream()
            .flatMap(author -> author.getBooks().stream())
            .map(book -> book.getScore())
            .max((o1, o2) -> o1-o2).ifPresent(System.out::println);

    authors.stream()
            .flatMap(author -> author.getBooks().stream())
           .map(book -> book.getScore())
           .min((o1, o2) -> o1-o2).ifPresent(System.out::println);
}
```

##### 注意：获取完一个最大值之后是不可以继续点去获取最小值的，需要重新去获取流对象，因为一个流经过一个流之后，就已经终止掉了，相当于结束关闭掉了，那               么你需要重新获取一个流才可以。



##### collect

​      把当前流转换为一个集合



例子：

​     获取一个存放所有作者名称的List集合。

```java
/**
 * 14、Stream流的使用
 */
@Test
void stream14() {
    //获取一个存放所有作者名称的List集合。
    List<Author> authors = getAuthors();
    authors.stream()
            .map(Author::getName)
            .distinct()
            .collect(Collectors.toList())
            .forEach(System.out::println);
}
```

​    获取一个所有书名的List和set集合。

```java
    /**
     * 15、Stream流的使用
     */
    @Test
    void stream15() {
        //获取一个所有书名的List集合。
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("------------------------");

        //获取一个所有书名的set集合
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

```

​    获取一个map集合，map的key为作者名，value为List<Book>

```java
/**
 * 16、Stream流的使用
 */
@Test
void stream16() {
    //获取一个map集合，map的key为作者名，value为List<Book>
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .collect(Collectors
                    .toMap(Author::getName, author -> author.getBooks()))
            .forEach((k, v) -> System.out.println(k + " : " + v));
}
```



##### 查找匹配  

##### anyMatch

​      可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。



例子：

​     判断是否有年龄29以上的作家。

```java
/**
 * 17、Stream流的使用
 */
@Test
void stream17() {
    //判断是否有年龄29以上的作家。
    List<Author> authors = getAuthors();
    boolean match = authors.stream()
            .anyMatch(author -> author.getAge() > 29);
    System.out.println(match);
}
```



##### allMatch

​    可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。



例子：

​    判断是否所有的作家都是成年人。

```java
/**
 * 18、Stream流的使用
 */
@Test
void stream18() {
    //判断是否所有的作家都是成年人
    List<Author> authors = getAuthors();
    boolean match = authors.stream()
            .allMatch(author -> author.getAge() >= 18);
    System.out.println(match);
}
```



##### noneMatch

​    可以判断流中的元素是否都不符合条件。如果都不符合则结果为true，否则结果为false



例子：

   判断作家是否都没有超过100岁。

```java
/**
 * 19、Stream流的使用
 */
@Test
void stream19() {
    //判断作家是否都没有超过100岁
    List<Author> authors = getAuthors();
    boolean match = authors.stream()
            .noneMatch(author -> author.getAge() <= 100);
    System.out.println(match);
}
```



##### findAny

​    获取流中的任意一个元素，该方法没有办法保证获取的一定是流中的第一个元素。



例子：

​    获取任意一个年龄大于14的作家，如果存在就输出他的名字。

```java
/**
 * 20、Stream流的使用
 */
@Test
void stream20() {
    //获取任意一个年龄大于14的作家，如果存在就输出他的名字。
    List<Author> authors = getAuthors();
    authors.stream()
            .filter(author -> author.getAge() > 14)
            .findAny()
            .ifPresent(author -> System.out.println(author.getName()));
}
```



##### findFirst

   获取流中的第一个元素。



例子：

   获取一个年龄最小的作家，并输出他的姓名。

```java
/**
 * 21、Stream流的使用
 */
@Test
void stream21() {
    //获取一个年龄最小的作家，并输出他的姓名。
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .sorted(Comparator.comparing(Author::getAge))
            .findFirst()
            .ifPresent(author -> System.out.println(author.getName()));
}
```



##### reduce归并

​     对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）

​     reduce的作用是把stream中的元素给组合起来，我们可以传入一个初始值，他会按照我们的计算方式依次拿流中的元素在初始化值的基础上进行计算，计算结果再和后面的元素进行计算。

​     他内部的计算方式如下：

```java
T result = identity;
for (T element : this stream)
    result = accumulator.apply(result, element);
return result;
```

​    其中identity就是我们可以通过方法参数传入的初始值，accumular的apply具体进行什么计算也是我们通过方法参数来确定的。



例子：

   使用reduce求所有作者年龄的和。

```java
    /**
     * 22、Stream流的使用
     */
    @Test
    void stream22() {
        //使用reduce求所有作者年龄的和
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, Integer::sum);//传入初始值0 identity   进行累加Integer::sum
        System.out.println("年龄之和："+sum);

        System.out.println("--------------------------");

        //符合规范 例子
        int[] arr={1,2,3,4,5};
        int result=0;
        for (int i : arr) {
            result+=i;
        }
        System.out.println("求和1："+result);

        //reduce相当于把上面的流程给抽取出来了
        int reduce = Arrays.stream(arr)
                .reduce(0, Integer::sum);
        System.out.println("求和2："+reduce);
    }
```

​    使用reduce求所有作者中年龄的最大值。

```java
/**
 * 23、Stream流的使用
 */
@Test
void stream23() {
    //使用reduce求所有作者中年龄的最大值。
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .map(Author::getAge)
            .reduce(Integer::max)
            .ifPresent(System.out::println);

    System.out.println("--------------------------");

    Integer max = authors.stream()
            .distinct()
            .map(Author::getAge)
            .reduce(Integer.MIN_VALUE, Integer::max);
    System.out.println(max);

    System.out.println("--------------------------");
    
    Integer reduce = authors.stream()
            .distinct()
            .map(Author::getAge)
            .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
    System.out.println(reduce);

}
```

​    使用reduce求所有作者中年龄最小的值

```java
/**
 * 24、Stream流的使用
 */
@Test
void stream24() {
    //使用reduce求所有作者中年龄最小的值
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .reduce(Integer::min)
            .ifPresent(System.out::println);

    System.out.println("---------------------");

    Integer reduce = authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .reduce(Integer.MAX_VALUE, new BinaryOperator<Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer < integer2 ? integer : integer2;
                }
            });
    System.out.println(reduce);

    System.out.println("---------------------");

    Integer result1 = authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .reduce(Integer.MAX_VALUE, (result, element) -> result < element ? result : element);
    System.out.println(result1);
    
    System.out.println("---------------------");

    Optional<Integer> minOptional = authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .reduce(new BinaryOperator<Integer>() {
               @Override
               public Integer apply(Integer integer, Integer integer2) {
                   return integer < integer2 ? integer : integer2;
               }
            });
    minOptional.ifPresent(System.out::println);
}
```



reduce一个参数的重载形式内部的计算

```java
 boolean foundAny = false;  
 T result = null;  
 for (T element : this stream) {      
     if (!foundAny) {          
         foundAny = true;          
         result = element;      
     }      
     else          
         result = accumulator.apply(result, element);  
 }  
 return foundAny ? Optional.of(result) : Optional.empty();
```



#### 3.5 注意事项

- ​    惰性求值（如果没有终结操作，没有中间操作是不会得到执行的）
- ​    流是一次性的（一旦一个流对象经过一个中介操作后，这个流就不能再被使用）
- ​    不会影响原数据（我们在流中可以多数据做很多处理。但是正常情况下是不会影响原来集合中的元素的，这往往也是我们期望的）

```java
/**
 * 25、Stream流的使用
 */
@Test
void stream25() {
    List<Author> authors = getAuthors();
    Stream<Author> stream = authors.stream();
    stream.map(author -> author.getName())
            .distinct()
            .forEach(name -> System.out.println(name));

    System.out.println("-----------------------");

    //java.lang.IllegalStateException: stream has already been operated upon or closed 需要重新去开一个流对象
    /*stream.map(author -> author.getName())
            .forEach(System.out::println);*/

    authors.stream()
            .distinct()
            .map(author -> author.getAge())
            .map(age -> age + 10)
            .forEach(System.out::println);
}
```



```java
@Test
void stream() {
    //查询作者
    authorServiceImpl.list().forEach(System.out::println);

    System.out.println("-----------------");

    bookServiceImpl.list().forEach(System.out::println);

    System.out.println("-----------------");

    authorServiceImpl.list().stream().distinct().filter(author -> {
        if (ObjectUtils.isEmpty(author.getBooks())) {
            author.setBooks(bookServiceImpl.list());
            return true;
        }
        return false;
    }).forEach(System.out::println);

}
```
