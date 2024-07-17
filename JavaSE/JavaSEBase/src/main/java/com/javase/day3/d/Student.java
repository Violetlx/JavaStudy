package com.javase.day3.d;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生类(枚举)
 * @author lixuan
 * @Date 2024/6/12 10:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person implements Study{
    //假如现在我们想给小明添加一个状态(跑步、学习、睡觉)，外部可以实时获取小明的状态

    /**
     * 状态，可以是跑步、学习、睡觉这三个之中的其中一种
     */
//    private String status;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    //但是上面这样会出现一个问题，如果我们仅仅是存储字符串，似乎外部可以不按照我们的规则，传入一些其他的字符串。这样显然是不够严谨的，那有没有
    //一种办法，能够更好地去实现这样的状态标记呢？我们希望开发者拿到使用的就是我们预先定义好的状态，所以我们可以使用枚举类来完成。

    /**
     * 类型变成刚刚定义的枚举类
     *
     * @SuppressWarnings("AlibabaRemoveCommentedCode") //忽略警告
     */
    @SuppressWarnings("AlibabaRemoveCommentedCode")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void study() {

    }
}
