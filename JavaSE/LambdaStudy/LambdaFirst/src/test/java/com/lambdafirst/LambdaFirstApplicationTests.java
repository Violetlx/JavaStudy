package com.lambdafirst;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lambdafirst.domain.entity.Author;
import com.lambdafirst.domain.entity.Book;
import com.lambdafirst.service.AuthorService;
import com.lambdafirst.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class LambdaFirstApplicationTests {

    @Resource
    private AuthorService authorServiceImpl;

    @Resource
    private BookService bookServiceImpl;

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
        });

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


    //Stream流


    /**
     * 静态对象
     */
    public static List<Author> getAuthors(){
        //数据初始化
        Author author=new Author(1L,"蒙多",33,"蒙多医生想去哪就去哪",null);
        Author author2=new Author(2L,"亚拉索",15,"狂风也追不上他的思考速度,疾风亦有归途",null);
        Author author3=new Author(3L,"易",16,"当我开启高原血统的时候,你拿什么抵挡",null);
        Author author4=new Author(3L,"易",16,"当我开启高原血统的时候,你拿什么抵挡",null);
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
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList=new ArrayList<>(Arrays.asList(author,author2,author3,author4));

        return authorList;

    }


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
    }


    /**
     * 3、Stream流的使用
     */
    @Test
    void stream3() {
        //打印所有姓名长度大于1的作家的名称
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {//把流中的每一个元素依次传入到Predicate中的test()方法进行筛选
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()>1;
                    }
                }).forEach(author -> System.out.println(author.getName()));

        System.out.println("----------------------------------");

        authors.stream()
                .filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));
    }


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

    /**
     * 16、Stream流的使用
     */
    @Test
    void stream16() {
        //获取一个map集合，map的key为作者名，value为List<Book>
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct() //map集合key不能重复
                .collect(Collectors
                        .toMap(Author::getName, author -> author.getBooks()))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

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


    //Optional

    public static Author getAuthor(){
        Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
        /*return null;*/
        return author;
    }

    public static Optional<Author> getAuthorOptional(){
        Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
        /*return null;*/
        return Optional.ofNullable(author);
    }

    public static Optional<Author> getOptionalAuthor(){
        Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
        return author==null?Optional.empty():Optional.of(author);
    }

    /**
     * 1、Optional的使用
     */
    @Test
    void optional1() {
        List<Author> authors = getAuthors();
        Stream<String> name = authors.stream()
                .map(author -> author.getName());
        if (name!=null){
            name.distinct()
                .forEach(System.out::println);
        }
    }

    /**
     * 2、Optional的使用
     */
    @Test
    void optional2() {
        Author author2 = getAuthor();
        //这种情况下是不会出现空指针异常的,可以尝试去把getAuthor()的返回值设置为null
        Optional<Author> authorOptional = Optional.ofNullable(author2);
        //因为当里面为null的时候,这里面的消费操作是不会被执行到的
        authorOptional.ifPresent(new Consumer<Author>() {
            @Override
            public void accept(Author author) {
                System.out.println(author.getName());
            }
        });

        System.out.println("--------------------------");

        //Lambda优化
        authorOptional.ifPresent(author -> System.out.println(author.getName()));

        System.out.println("--------------------------");

        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author1 -> {
                    Optional<Author> author = Optional.ofNullable(author1);
                    System.out.println(author.get().getName());
                });

        System.out.println("--------------------------");

        Optional<List<Author>> authors1 = Optional.ofNullable(authors);
        System.out.println(authors1.get().size());
    }


    /**
     * 3、Optional的使用
     */
    @Test
    void optional3() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
    }


    /**
     * 4、Optional的使用
     */
    @Test
    void optional4() {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.of(author);
        authorOptional.ifPresent(author1 -> System.out.println(author1.getName()));
    }


    /**
     * 5、Optional的使用
     */
    @Test
    void optional5() {
        Author author = getAuthor();
        Optional<Author> author1 = Optional.ofNullable(author);
        //ifPresent 如果这个数据值是存在的话,那么就会对其进行相应的消费操作
        author1.ifPresent(author2 -> System.out.println(author2.getName()));
    }

    /**
     * 6、Optional的使用
     */
    @Test
    void optional6() {
        Optional<Author> authorOptional = getAuthorOptional();
        Author author = authorOptional.get();
        System.out.println(author);
    }


    /**
     * 7、Optional的使用
     */
    @Test
    void optional7() {
        Optional<Author> authorOptional = Optional.ofNullable(getAuthor());
        String name = authorOptional.orElseGet(new Supplier<Author>() {
            @Override
            public Author get() {
                //有值就返回没有值就返回默认值
                return new Author();
            }
        }).getName();

        System.out.println(name);

        System.out.println("--------------------------");

        //Lambda表达式优化
        Author author = authorOptional.orElseGet(() -> new Author());
        System.out.println(author);
    }


    /**
     * 8、Optional的使用
     */
    @Test
    void optional8() throws Throwable {
        Optional<Author> authorOptional = getOptionalAuthor();
        authorOptional.orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new RuntimeException("出现异常了");
            }
        });

        System.out.println("--------------------------");

        //Lambda表达式优化
        authorOptional.orElseThrow(() -> new RuntimeException("出现异常了"));
    }


    /**
     * 9、Optional的使用
     */
    @Test
    void optional9() {
        Optional<Author> authorOptional = getAuthorOptional();
        //filter 过滤掉不符合条件的数据

        //要求年龄大于30岁
        authorOptional.filter(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge()>30;
            }
        }).ifPresent(author -> System.out.println(author.getName()));

        System.out.println("--------------------------");

        //Lambda表达式优化
        //要求年龄小于30岁
        /**
         * 当不符合要求的时候,会产生一个新的Optional对象,这个对象值为null
         */
        Optional<Author> authorOptional1 = authorOptional.filter(author -> author.getAge() < 30);
        System.out.println(authorOptional1);//Optional.empty
        authorOptional1.ifPresent(author -> System.out.println(author.getName()));

        //相当于不为空,并且年龄小于30岁的作者
    }


    /**
     * 10、Optional的使用
     */
    @Test
    void optional10() {
        Optional<Author> authorOptional = getAuthorOptional();
        if (authorOptional.isPresent()) {//判断是否存在值
            System.out.println(authorOptional.get().getName());
        } else {
            System.out.println("没有值");
        }
    }


    /**
     * 11、Optional的使用
     */
    @Test
    void optional11() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> {
                    Optional.ofNullable(author)
                            .map(Author::getBooks)
                            .ifPresent(books -> {
                                books.stream()
                                        .distinct()
                                        .map(book -> book.getName())
                                        .distinct()
                                        .forEach(System.out::println);
                            });;
                });

        System.out.println("--------------------------");

        Optional<Author> authorOptional = getAuthorOptional();
        //map 映射
        Optional<List<Book>> books = authorOptional.map(author -> author.getBooks());
        books.ifPresent(book -> System.out.println(book));

        System.out.println("--------------------------");

        Optional<String> nameOptional = authorOptional.map(author -> author.getName());
        System.out.println(nameOptional.get());

        System.out.println("--------------------------");

        nameOptional.ifPresent(name -> System.out.println(name));

        System.out.println("--------------------------");

        authorOptional.map(new Function<Author, Integer>() {
            @Override
            public Integer apply(Author author) {
                return author.getAge();
            }
        }).ifPresent(age -> System.out.println(age));
    }



    //5 函数式接口

    /**
     * 1、函数式接口的使用
     */
    @Test
    void functionInterface1() {
        //打印作家中年龄大于等于17并且姓名的长度大于1的作家。
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getAge()>=18)
                .filter(author -> author.getName().length()>1)
               .forEach(author -> System.out.println(author.getName()+"今年"+author.getAge()+"岁了"));

        System.out.println("--------------------------");

        /**
         * and是Predicate的默认方法
         */
        authors.stream()
                .distinct()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) { //这个匿名内部类里面就相当于是一个Predicate对象

                        return author.getAge()>=17;
                    }
                }.and(new Predicate<Author>() { //调用对象里面的方法
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()>1;
                    }
                })).forEach(author -> System.out.println(author.getName()+"今年"+author.getAge()+"岁了"));

        System.out.println("--------------------------");

        //Lambda表达式优化
        authors.stream()
                .distinct()
                .filter(((Predicate<Author>) author -> author.getAge() >= 17)
                        .and(author -> author.getName().length()>1))
                .forEach(author -> System.out.println(author.getName()+"今年"+author.getAge()+"岁了"));

    }

    public static void printNum(IntPredicate predicate,IntPredicate predicate2){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.and(predicate2).test(i)){//and是Predicate的默认方法
                System.out.println(i);
            }
        }
    }

    /**
     * 2、函数式接口的使用
     */
    @Test
    void functionInterface2() {
        //要求获取i%2==0和i%3==0同时满足的数
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%2==0;
            }
        }.and(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%3==0;
            }
        }));


        System.out.println("-----------------");

        //Lambda优化
        printNum(i -> i%2==0,i -> i%3==0);
    }


    /**
     * 3、函数式接口的使用
     */
    @Test
    void functionInterface3() {
        //打印作家中年龄大于17或者姓名长度小于2的作家。
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.or(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()<2;
                    }
                })).forEach(System.out::println);

        System.out.println("--------------------------");

        //Lambda表达式优化
        authors.stream()
                .distinct()
                .filter(((Predicate<Author>) author -> author.getAge()>17)
                       .or(author -> author.getName().length()<2))
                .forEach(System.out::println);
    }

    /**
     * 4、函数式接口的使用
     */
     @Test
    void functionInterface4() {
         //打印作家年龄不大于17的作家
         List<Author> authors = getAuthors();
         authors.stream()
                 .distinct()
                 .filter(new Predicate<Author>() {
                     @Override
                     public boolean test(Author author) {
                         return author.getAge()>17;
                     }
                 }.negate())
                 .forEach(author -> System.out.println(author.getName()));

         System.out.println("-------------------------");

         authors.stream()
                 .distinct()
                 .filter(new Predicate<Author>() {
                     @Override
                     public boolean test(Author author) {
                         return !(author.getAge() >17);
                     }
                 }).forEach(author -> System.out.println(author.getName()));

         System.out.println("-------------------------");

         //Lambda表达式优化
         authors.stream()
                 .distinct()
                 .filter(((Predicate<Author>) author -> author.getAge()>17 ).negate())
                 .forEach(author -> System.out.println(author.getName()));
     }


     //方法引用

    /**
     * 1、方法引用
     */
    @Test
    void methodReference() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .map(Author::getAge)
                .forEach(System.out::println);
    }


    /**
     * 2、方法引用
     */
    @Test
    void methodReference2() {
        List<Author> authors = getAuthors();

        /**
         * 如果我们在重写方法的时候，方法中**只有一行代码**，
         * 并且这行代码是调用了**某个类的静态方法**，并且
         * 我们把要重写的**抽象方法中所有的参数按照顺序传入
         * 了这个静态方法中**，这个时候我们就可以引用这个类的静态方法了
         */
        authors.stream()
                .distinct()
                .map(new Function<Author, Integer>() {
                    @Override
                    public Integer apply(Author author) {//方法体中只有一行代码
                        return author.getAge();
                    }
                }).map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer age) {
                        return String.valueOf(age);
                    }
                }).forEach(new Consumer<String>() {
                    @Override
                    public void accept(String age) {
                        System.out.println(age);
                    }
                });

        System.out.println("-----------------------");

        //Lambda表示式优化
        Stream<Author> authorStream = authors.stream();
        authorStream.distinct()
                .map(author -> author.getAge())
                .map(age->String.valueOf(age))
                .forEach(age -> System.out.println(age));

        System.out.println("-----------------------");

        //方法引用优化
        authors.stream()
                .distinct()
                .map(Author::getAge)
                .map(String::valueOf)
                .forEach(System.out::println);
    }


    /**
     * 3、方法引用
     */
    @Test
    void methodReference3() {
        List<Author> authors = getAuthors();

        Stream<Author> authorStream = authors.stream();
        StringBuffer stringBuffer=new StringBuffer();
        authorStream.distinct()
                .map(author -> author.getName())
                .forEach(name -> stringBuffer.append(name).append(','));

        System.out.println(stringBuffer);

        System.out.println("-----------------------");

        StringBuffer stringBuffer1 = new StringBuffer();

        Stream<Author> stream = authors.stream();
        stream.distinct()
                .map(Author::getName)
               .forEach(stringBuffer1::append);
        System.out.println(stringBuffer1);
    }


    /**
     * 4、方法引用
     */
    interface UseString{
        String use(String str,int start,int length);
    }

    public static String subAuthorName(String str,UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }

    @Test
    void methodReference4() {
        /**
         * 如果我们在重写方法的时候，方法体中**只有一行代码**，
         * 并且这行代码是**调用了第一个参数的成员方法**，并且
         * 我们把要**重写的抽象方法中剩余的参数都按照顺序传入
         * 这个成员方法中**，这个时候我们就可以引用类的实例方法。
         */
        String s = subAuthorName("LX", new UseString() {
            @Override
            public String use(String str, int start, int length) {
                return str.substring(start, length);
            }
        });
        System.out.println(s);

        System.out.println("-----------------------");

        //优化
        String s1 = subAuthorName("LX", String::substring);

        System.out.println(s1);
    }


    /**
     * 5、方法引用
     */
    @Test
    void methodReference5() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .map(name->new StringBuffer(name))
                .map(sb->sb.append("LX").toString())
                .forEach(str-> System.out.println(str));

        System.out.println("-----------------------");

        //构造器方法引用优化
        authors.stream()
                .map(Author::getName)
                .map(StringBuffer::new)
                .map(sb->sb.append("LX").toString())
                .forEach(System.out::println);
    }


    //7、高级用法

    /**
     * 1、高级用法的使用
     */
    @Test
    void lambdaHigher() {
        List<Author> authors = getAuthors();

        authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);

        System.out.println("-----------------------");

        authors.stream()
                .distinct()
                .mapToInt(new ToIntFunction<Author>() {
                    @Override
                    public int applyAsInt(Author author) {
                        return author.getAge();
                    }
                })
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);

        System.out.println("-----------------------");

        //优化 mapToInt 避免了频繁的装箱和拆箱的过程
        authors.stream()
                .distinct()
                .mapToInt(Author::getAge)
                .map(age -> age+10)
                .filter(age->age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }

    /**
     * 2、高级用法的使用
     */
    @Test
    void lambdaHigher2() {
        Stream.of(1,2,3,4,5,6,7,8,9,10)
               .filter(i -> i%2==0)
               .map(i -> i*i)
               .forEach(System.out::println);

        System.out.println("-----------------------");

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream.parallel()//并行流
                .filter(num -> num > 5)
                .reduce(Integer::sum)
                .get();
        System.out.println(sum);

        System.out.println("-----------------------");

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream1.parallel()
                .peek(new Consumer<Integer>() {//peek 不会改变流的状态
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer+Thread.currentThread().getName());//打印线程名 看你在那个线程里面
                    }
                })
                .filter(num -> num > 5)
                .reduce(Integer::sum)
                .get();
    }


    /**
     * 3、高级用法的使用
     */
    @Test
    void lambdaHigher3() {
        List<Author> authors = getAuthors();
        authors.parallelStream()
                .distinct()
                .mapToInt(Author::getAge)
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }



}
