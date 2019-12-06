package com.omg.utils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService pool = createThreadPool("thread-%d");
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyTask());
        }
//        pool.shutdown();
    }

    public static ExecutorService createThreadPool(String name) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat(name)
                .setDaemon(true)
                .build();
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }


    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread name:"
                    + Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() + ":Thread id:"
                    + Thread.currentThread().getId());
            try {
                System.out.println("www");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    https://www.cnblogs.com/hapjin/p/7599189.html
}