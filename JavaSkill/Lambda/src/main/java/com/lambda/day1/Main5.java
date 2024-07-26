package com.lambda.day1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 02-有形的函数二
 * @author lixuan
 * @Date 2024/7/18 10:21
 */
public class Main5 {
    interface Lambda extends Serializable {
        int calculate(int a, int b);
    }

    static class Server {
        public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("server start...");
            while (true) {
                Socket s = ss.accept();
                // 创建一个线程池，这里假设创建一个固定大小为 10 的线程池
                ExecutorService executor = Executors.newFixedThreadPool(10);

                // 提交任务给线程池执行
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
                            Lambda lambda = (Lambda) is.readObject();
                            int a = ThreadLocalRandom.current().nextInt(10);
                            int b = ThreadLocalRandom.current().nextInt(10);
                            System.out.printf("%s %d op %d = %d%n", s.getRemoteSocketAddress().toString(), a, b, lambda.calculate(a, b));
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });

                // 关闭线程池
                executor.shutdown();
            }
        }
    }

    // Server 虚拟机端必须有 Client0 这个类，相当于把实现绑定在了服务器端
    static class Client0 {
        int add(int a, int b) {
            return a + b;
        }
    }


    // Server 虚拟机端只需有 Lambda 接口定义，实现与服务器无关
    static class Client1 {
        public static void main(String[] args) throws IOException {
            try(Socket s = new Socket("127.0.0.1", 8080)){
                Lambda lambda = (a, b) -> a + b;
                ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
                os.writeObject(lambda);
                os.flush();
            }
        }
    }
    static class Client2 {
        public static void main(String[] args) throws IOException {
            try(Socket s = new Socket("127.0.0.1", 8080)){
                Lambda lambda = (a, b) -> a - b;
                ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
                os.writeObject(lambda);
                os.flush();
            }
        }
    }
    static class Client3 {
        public static void main(String[] args) throws IOException {
            try(Socket s = new Socket("127.0.0.1", 8080)){
                Lambda lambda = (a, b) -> a * b;
                ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
                os.writeObject(lambda);
                os.flush();
            }
        }
    }
}
