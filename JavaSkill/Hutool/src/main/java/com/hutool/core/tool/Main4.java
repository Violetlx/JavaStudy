package com.hutool.core.tool;

import cn.hutool.core.util.HashUtil;

/**
 * Hash算法-HashUtil
 * @author lixuan
 * @Date 2024/12/25 15:28
 */
public class Main4 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * additiveHash 加法 hash
     * rotatingHash 旋转 hash
     * oneByOneHash 一次一个 hash
     * bernstein Bernstein's hash
     * universal Universal Hashing
     * zobrist Zobrist Hashing
     * fnvHash 改进的 32 位 FNV 算法
     * intHash Thomas Wang 的算法，整数 hash
     * rsHash RS 算法 hash
     * jsHash JS 算法 hash
     * pjwHash PJW 算法
     * elfHash ELF 算法
     * bkdrHash BKDR 算法
     * sdbmHash SDBM 算法
     * djbHash DJB 算法
     * dekHash DEK 算法
     * apHash AP 算法
     * tianlHash TianL Hash 算法
     * javaDefaultHash JAVA 自带的算法
     * mixHash 混合 hash 算法，输出 64 位的值
     */
    private static void test1() {
        // a 97 b 98 c 99
        // additiveHash 加法 hash
        int additiveHash = HashUtil.additiveHash("abc", 100);
        System.out.println("test1--additiveHash==>"+additiveHash);

        // rotatingHash 旋转 hash
        int rotatingHash = HashUtil.rotatingHash("abc", 100);
        System.out.println("test1--rotatingHash==>"+rotatingHash);

        // oneByOneHash 一次一个 hash
        int oneByOneHash = HashUtil.oneByOneHash("abc");
        System.out.println("test1--oneByOneHash==>"+oneByOneHash);

        // bernstein Bernstein's hash
        int bernstein = HashUtil.bernstein("abc");
        System.out.println("test1--bernstein==>"+bernstein);

        // fnvHash 改进的 32 位 FNV 算法
        int fnvHash = HashUtil.fnvHash("abc");
        System.out.println("test1--fnvHash==>"+fnvHash);

        // intHash Thomas Wang 的算法，整数 hash
        int intHash = HashUtil.intHash(123);
        System.out.println("test1--intHash==>"+intHash);

        // rsHash RS 算法 hash
        int rsHash = HashUtil.rsHash("abc");
        System.out.println("test1--rsHash==>"+rsHash);

        // jsHash JS 算法 hash
        int jsHash = HashUtil.jsHash("abc");
        System.out.println("test1--jsHash==>"+jsHash);

        // pjwHash PJW 算法
        int pjwHash = HashUtil.pjwHash("abc");
        System.out.println("test1--pjwHash==>"+pjwHash);

        // elfHash ELF 算法
        int elfHash = HashUtil.elfHash("abc");
        System.out.println("test1--elfHash==>"+elfHash);

        // bkdrHash BKDR 算法
        int bkdrHash = HashUtil.bkdrHash("abc");
        System.out.println("test1--bkdrHash==>"+bkdrHash);

        // sdbmHash SDBM 算法
        int sdbmHash = HashUtil.sdbmHash("abc");
        System.out.println("test1--sdbmHash==>"+sdbmHash);

        // djbHash DJB 算法
        int djbHash = HashUtil.djbHash("abc");
        System.out.println("test1--djbHash==>"+djbHash);

        // dekHash DEK 算法
        int dekHash = HashUtil.dekHash("abc");
        System.out.println("test1--dekHash==>"+dekHash);

        // apHash AP 算法
        int apHash = HashUtil.apHash("abc");
        System.out.println("test1--apHash==>"+apHash);

        // tianlHash TianL Hash 算法
        long tianlHash = HashUtil.tianlHash("abc");
        System.out.println("test1--tianlHash==>"+tianlHash);

        // javaDefaultHash JAVA 自带的算法
        int javaDefaultHash = HashUtil.javaDefaultHash("abc");
        System.out.println("test1--javaDefaultHash==>"+javaDefaultHash);

        // mixHash 混合 hash 算法，输出 64 位的值
        long mixHash = HashUtil.mixHash("abc");
        System.out.println("test1--mixHash==>"+mixHash);

        //结果：
        //test1--additiveHash==>97
        //test1--rotatingHash==>39
        //test1--oneByOneHash==>-317513893
        //test1--bernstein==>108966
        //test1--fnvHash==>34757373
        //test1--intHash==>1098118400
        //test1--rsHash==>822160044
        //test1--jsHash==>895805535
        //test1--pjwHash==>26499
        //test1--elfHash==>26499
        //test1--bkdrHash==>1677554
        //test1--sdbmHash==>807794786
        //test1--djbHash==>193485963
        //test1--dekHash==>2083
        //test1--apHash==>-25651485
        //test1--tianlHash==>33734718
        //test1--javaDefaultHash==>96354
        //test1--mixHash==>413837313596157

        // 解析hash

    }
}
