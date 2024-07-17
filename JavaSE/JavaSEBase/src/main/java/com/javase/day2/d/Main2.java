package com.javase.day2.d;

/**
 * 选择结构
 * @author lixuan
 * @Date 2024/4/30 10:29
 */
public class Main2 {
    public static void main(String[] args) {
        //if (条件判断) 判断成功执行的代码;

        int a = 15;
        //只有当a判断等于15时，才会执行下面的打印语句
        if(a == 15)
            System.out.println("Hello World!");
        //if只会对紧跟着的一行代码生效，后续的内容无效
        System.out.println("我是外层");

        System.out.println("----------------------------");

        /*
         * if回进行判断，只有判断成功时才会执行紧跟着的语句，否则会直接跳过。
         * 注意如果我们想要在if中执行多行代码，需要使用代码块将这些代码囊括起来(实际上代码块就是将多条语句复合到一起)
         * 所以说，我们以后使用if时，如果分支中有多行
         */
        //只有判断成功时，才会执行下面的代码块中内容，否则直接跳过
        if(a > 10) {
            System.out.println("a大于10");
            System.out.println("a的值为："+a);
        }
        System.out.println("我是外层");

        System.out.println("----------------------------");

        //只有判断成功时，才会执行下面的代码块中内容，否则直接跳过
        if(a > 10) {
            System.out.println("a大于10");
            System.out.println("a的值为："+a);
        } else {   //当判断不成功时，会执行else代码块中的代码
            System.out.println("a小于10");
            System.out.println("a的值为："+a);
        }
        System.out.println("我是外层");


        System.out.println("----------------------------");

        //else-if  多个分支的情况

        int score =  2;
        //90分以上才是优秀
        if(score >= 90)
            System.out.println("优秀");
            //当上一级if判断失败时，会继续判断这一级
        else if (score >= 70)
            System.out.println("良好");
        else if (score >= 60)
            System.out.println("及格");
            //当之前所有的if都判断失败时，才会进入到最后的else语句中
        else
            System.out.println("不及格");
        System.out.println("我是外层");

        System.out.println("----------------------------");

        //if-else 语句支持嵌套使用

        //0-30补java 30-60补C++
        //先判断不及格
        if(score < 60) {
            //在内层再嵌套一个if语句进行进一步的判断
            if(score > 30)
                System.out.println("学习C++");
            else
                System.out.println("学习Java");
        }


        System.out.println("----------------------------");

        /**
         * Switch语句  适用于多分支的情况
         * switch语句的语法格式如下：
         * switch (目标) {   //我们需要传入一个目标，比如变量，或是计算表达式等
         *   case 匹配值:    //如果目标的值等于我们这里给定的匹配值，那么就执行case后面的代码
         *     代码...
         *     break;    //代码执行结束后需要使用break来结束，否则会溜到下一个case继续执行代码
         * }
         */

        //对学生等级进行分班，学生有ABC三个等级

        char c = 'A';
        //这里目标就是变量c
        switch (c) {
            //分别指定ABC三个匹配值，并且执行不同的代码
            case 'A':
                System.out.println("去尖子班！准备冲刺985大学！");
                break;   //执行完之后一定记得break，否则会继续向下执行下一个case中的代码
            case 'B':
                System.out.println("去平行班！准备冲刺一本！");
                break;
            case 'C':
                System.out.println("去职高深造。");
                break;
            //默认情况
            default:
                System.out.println("没有这个等级！");
        }

        //switch可以精准匹配某个值，但是它不能进行范围判断，比如我们要判断分数，这时用switch就很鸡肋了。

        //default 当然除了精准匹配之外，其他的情况我们可以用default来表示

        System.out.println("----------------------------");

        //switch和if可以嵌套使用
        switch (c) {
            //嵌套一个if语句
            case 'A':
                if(c == 'A') {
                    System.out.println("去尖子班！");
                }
                break;
            case 'B':
                System.out.println("去平行班！");
                break;
            default:
                System.out.println("没有这个等级！");
        }





    }
}
