### 4 Optional

#### 4.1 概述

​      我们在编写代码的时候出现的最多的就是空指针异常。所以在很多情况下我们需要作各种非空的判断。

例如：

```java
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
```

尤其是判断对象中的一个属性还是一个对象的情况下。这种判断会更多。

而过多的判断语句会让我们的代码臃肿不堪。

所以在JDK8中引用了Optional,养成使用Optional的习惯后你可以写出更加优雅的代码来避免空指针异常。

并且在很多函数式编程相关的API中也都用到了Optional，如果不会使用Optional也会对函数式编程的学习造成影响。



#### 4.2 使用

##### 4.2.1 创建对象

​    Optional就好像是包装类，可以把我们的具体数据封装到Optional对象内部，然后我们再去使用Optional中封装好的方法操作封装进去的数据就可以非常优雅的避免空指针异常。



   我们一般使用**Optional**的**静态方法ofNullable**来把数据封装成一个Optioanal对象。无论传入的参数是否为null都不会出现问题。

```java
public static Author getAuthor(){
    Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
    return author;
}
```

```java
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

```

   你可能会觉得还要加一行代码来封装数据比较麻烦，但是如果改造一下getAuthor()方法，让其返回值就是封装好的Optional的话，我们在使用的时候就方便很多。

```java
public static Optional<Author> getAuthorOptional(){
    Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
    return Optional.ofNullable(author);
}
```

```java
/**
 * 3、Optional的使用
 */
@Test
void optional3() {
    Optional<Author> authorOptional = getAuthorOptional();
    authorOptional.ifPresent(author -> System.out.println(author.getName()));
}
```

   而且在实际开发中我们的数据很多是从数据库中获取的。Mybatsi从3.5版本也已经可以支持Optional了。我们可以直接把dao方法的返回值类型定义为Optional类型，Mybatis会自己把数据封装成Optional对象，封装的过程也不需要我们进行操作。



   如果你确定一个对象不为空的则可以使用**Optiional**的**静态方法of**来把数据封装成Optional对象。

```java
/**
 * 4、Optional的使用
 */
@Test
void optional4() {
    Author author = getAuthor();
    Optional<Author> authorOptional = Optional.of(author);
    authorOptional.ifPresent(author1 -> System.out.println(author1.getName()));
}
```

   但是一定要注意，如果使用of的时候传入参数必须不为null。（尝试下传入null会出现什么结果）

```java
java.lang.NullPointerException
```



##### ofNullable()

```java
public static <T> Optional<T> ofNullable(T value) {
    return value == null ? empty() : of(value);
}
```

   

​    如果一个方法的返回值类型是Optional类型。而如果我们经过判断发现某次计算得到的返回值为null，这个时候就需要把null封装成Optional对象返回。这时则可以使用**Optional**的**静态方法empty**来进行封装。

```java
    Optional.empty()
```

```java
public static Optional<Author> getOptionalAuthor(){
    Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
    return author==null?Optional.empty():Optional.of(author);
}
```

##### 综上所述：

​      推荐使用ofNullable()的方法，而不推荐用of方法手动去写判断，ofNullable()里面就有判断方法。



##### 4.2.2 安全消费值

我们获取到一个Optional对象后肯定需要对其中的数据进行使用。这时候我们可以使用其ifPresent方法来消费其中的值。

这个方法会判断其内封装的数据是否为空，不为空时才会执行具体的消费代码。这样使用起来就更加安全了。

例如：

​      一下写法就优雅的避免了空指针异常。

```java
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
```



##### 4.2.3 获取值

​    如果我们想获取值自己进行处理可以使用get()方法获取，但是不推荐。因为当Optional内部的数据为空的时侯会出现异常。

```java
/**
 * 6、Optional的使用
 */
@Test
void optional6() {
    Optional<Author> authorOptional = getAuthorOptional();
    Author author = authorOptional.get();
    /* 
     * get()
     * 如果此Optional存在值,则返回该值,否则会抛出NoSuchElementException
     */
    System.out.println(author);
}
```

```java
public static Optional<Author> getAuthorOptional(){
    Author author=new Author(1L,"蒙多",33,"一个从菜刀中寻找哲理的祖安狂人",null);
    /*return null;*/
    return Optional.ofNullable(null);
}
```

当传入为null的时候使用get()会有问题。java.util.NoSuchElementException: No value present

所以不推荐使用.get()方法来获取值的。



##### 4.2.4 安全获取值

如果我们期望安全的获取值，我们不推荐使用.get()方法，而是使用Optional提供的以下方法。

- orElseGet

  获取数据并且设置数据为空时的默认值，如果数据不为空就能获取到该数据。如果为空时则根据你传入的参数来创建对象作为默认值返回。

  ```java
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
  ```

​		

- orElseThrow

  获取数据，如果数据不为空就能获取到该数据。如果为空则根据你传入的参数来创建异常抛出。

  使用Spring框架的时候，可以去抛出异常做统一的异常捕获，做统一的异常处理。

  ```java
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
  ```



##### 4.2.5 过滤

​     我们可以使用filter方法来对数据进行过滤。如果原本是有数据的，但不符合判断，也会变成一个无数据的Optional对象。

```java
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
```





##### 4.2.6 判断

  我们可以使用isPresent方法进行是否存在数据的判断。如果为空返回值为false，如果不为空，返回值为true。但是这种方式并不能体现Optional的好处，**更推荐使用ifPresent方法**。

```java
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
```



##### 4.2.7 数据转换

​     Optional还提供了可以让我们对数据进行转换，并且转换得到的数据也还是Optional包装好的，保证了我们的使用更加安全。

例如：

​    我们想要获取作家的书籍集合。

```java
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
```



##### 总结：

##### 创建

##### 安全的消费值