package com.javase.day2.d;

/**
 * 循环结构(一) for循环
 * @author lixuan
 * @Date 2024/5/28 12:11
 */
public class Main3 {
    public static void main(String[] args) {
        //for (表达式1;表达式2;表达式3) 循环体;
        for (int i = 1; i < 4; i++) {
            System.out.println("伞兵"+i+"号卢本伟准备就绪！！！");
        }

        /*
         *详细规则
         * 表达式1：在循环开始时仅执行一次
         * 表达式2：每次循环开始前会执行一次，要求为判断语句，用于判断是否可以结束循环，若结果为真，那么继续循环，否则结束循环。
         * 表达式3：每次循环完成后会执行一次。
         * 循环体：每次循环都会执行一次循环体
         */

        System.out.println("------------------------------");

        //这里的i仅仅是for循环语句中创建的变量，所以说其作用域被限制在循环体中，一旦离开循环体，那么就无法使用了

        //但是我们可以将i的创建放在外面
        //在外面创建变量k，这样全部范围内都可以使用了
        int k = 0;
        //for循环的三个表达式并不一定需要编写
        for (; k < 3; k++) {
            System.out.println("伞兵一号卢本伟准备就绪！");
            System.out.println("当前i的值为："+k);
        }
        System.out.println("当前i的值为："+k);

        System.out.println("------------------------------");

        //for循环嵌套

        //3*3=9

        //外层循环执行3次
        for (int i = 0; i < 3; i++)
            //内层循环也执行3次
            for (int j = 0; j < 3; j++)
                System.out.println("1！5！");


        System.out.println("------------------------------");

        //continue和break

        //continue：跳过本次循环，继续下一次循环
        for (int i = 0; i < 3; i++) {
            if (i == 1)
                continue;
            System.out.println("伞兵一号卢本伟准备就绪！");
        }

        System.out.println("------------------------------");

        //break：跳出循环，结束循环
        for (int i = 0; i < 3; i++) {
            if (i == 1)
                break;
            System.out.println("伞兵一号卢本伟准备就绪！");
        }


        System.out.println("------------------------------");

        //continue和break在嵌套循环中的使用
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                if (i == 1)
                    continue;
//                if (j == 1)
//                    break;
                System.out.println("伞兵一号卢本伟准备就绪！");
            }
        }

        System.out.println("------------------------------");

        //如果什么都不写，相当于没有结束条件，这将会导致无限循环
//        for (;;)
//            System.out.println("伞兵一号卢本伟准备就绪！");

    }
}
