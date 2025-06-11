package com.hutool.core.tool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.URLUtil;

import java.net.URI;
import java.net.URL;

/**
 * URL工具-URLUtil
 * @author lixuan
 * @Date 2024/12/25 16:45
 */
public class Main5 {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------------------");
        test2();
    }

    /**
     * 1 获取 URL 对象
     */
    private static void test1() {
        String str = "https://picx.zhimg.com/v2-62a937b540a6c8156c5798805d799c4d_1440w.jpg";
        URL url = URLUtil.url(str);
        System.out.println("test1--url==>"+url);

        URI uri = URLUtil.getHost(url);
        System.out.println("test1--uri==>"+uri);

        URL getUrl = URLUtil.getURL(FileUtil.file("E:\\Study\\JavaSkill\\Hutool\\src\\main\\java\\com\\hutool\\core\\tool\\Main5.java"));
        System.out.println("test1--getUrl==>"+getUrl);

        //结果：
        //test1--url==>https://picx.zhimg.com/v2-62a937b540a6c8156c5798805d799c4d_1440w.jpg
        //test1--uri==>https://picx.zhimg.com
        //test1--getUrl==>file:/E:/Study/JavaSkill/Hutool/src/main/java/com/hutool/core/tool/Main5.java
    }

    /**
     * 2 其他
     */
    private static void test2() {
        //该方法用于标准化URL链接，代码如下：
        String url1 = "https://images5.alphacoders.com\\854\\thumb-1920-854436.png";
        String normalize = URLUtil.normalize(url1);
        System.out.println("test2--normalize==>"+normalize);

        //该方法用于获取URL链接中的path部分字符串，比如：
        String url2 = "https://images5.alphacoders.com/854/thumb-1920-854436.png?name=violet";
        String pathStr = URLUtil.getPath(url2);
        System.out.println("test2--pathStr==>"+pathStr);

        //URLUtil.encode 封装URLEncoder.encode，将需要转换的内容（ASCII码形式之外的内容）
        //用十六进制表示法转换出来，并在之前加上%开头。
        String body = "366466 - 副本.jpg";
        // 结果为：366466%20-%20%E5%89%AF%E6%9C%AC.jpg
        String encode = URLUtil.encode(body);
        System.out.println("test2--encode==>"+encode);

        //URLUtil.decode 封装URLDecoder.decode，将%开头的16进制表示的内容解码。
        String decode = URLUtil.decode(encode);
        System.out.println("test2--decode==>"+decode);

        //转URL或URL字符串为URI。
        String urlStr = "https://images5.alphacoders.com/854/thumb-1920-854436.png";
        URI toURI = URLUtil.toURI(urlStr);
        System.out.println("test2--toURI==>"+toURI);

        //结果：
        //test2--normalize==>https://images5.alphacoders.com/854/thumb-1920-854436.png
        //test2--pathStr==>/854/thumb-1920-854436.png
        //test2--encode==>366466%20-%20%E5%89%AF%E6%9C%AC.jpg
        //test2--decode==>366466 - 副本.jpg
        //test2--toURI==>https://images5.alphacoders.com/854/thumb-1920-854436.png
    }
}
