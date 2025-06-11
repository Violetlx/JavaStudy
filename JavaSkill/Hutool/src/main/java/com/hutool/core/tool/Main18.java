package com.hutool.core.tool;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 唯一ID工具-IdUtil
 * @author lixuan
 * @Date 2025/1/9 11:41
 */
public class Main18 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
        System.out.println("---------------------------");
        test3();
    }

    /**
     * 1.UUID
     */
    public static void test1() {
        //生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        System.out.println("test1--uuid==>"+uuid);

        //生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println("test1--simpleUUID==>"+simpleUUID);

        String fastSimpleUUID = IdUtil.fastSimpleUUID();
        System.out.println("test1--fastSimpleUUID==>"+fastSimpleUUID);
        String fastUUID = IdUtil.fastUUID();
        System.out.println("test1--fastUUID==>"+fastUUID);

        //结果：
        //test1--uuid==>4873489f-e80c-4a44-8c21-c5fc34c264f2
        //test1--simpleUUID==>876ed5dc11d044aebb0547a3321ed298
        //test1--fastSimpleUUID==>caea9cc54e914790b7b438c505cd7b78
        //test1--fastUUID==>7864d747-3579-44e4-a4b9-53cf85afcbb9
    }

    /**
     * 2.ObjectId
     */
    public static void test2() {
        String objectId = IdUtil.objectId();
        System.out.println("test2--objectId==>"+objectId);

        //生成类似：5b9e306a4df4f8c54a39fb0c
        String id = ObjectId.next();
        System.out.println("test2--id==>"+id);

        //方法2：从Hutool-4.1.14开始提供
        String id2 = IdUtil.objectId();
        System.out.println("test2--id2==>"+id2);

        //结果：
        //test2--objectId==>677f468a502e7e99744a5a9c
        //test2--id==>677f468a502e7e99744a5a9d
        //test2--id2==>677f468a502e7e99744a5a9e
    }

    /**
     * 3.Snowflake
     */
    public static void test3() {
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println("test3--id==>"+id);

        //简单使用
        long id1 = IdUtil.getSnowflakeNextId();
        String id2 = IdUtil.getSnowflakeNextIdStr();
        System.out.println("test3--id1==>"+id1);
        System.out.println("test3--id2==>"+id2);

        //结果：
        //test3--id==>1877200198204264448
        //test3--id1==>1877200198425829376
        //test3--id2==>1877200198425829377
    }

}
