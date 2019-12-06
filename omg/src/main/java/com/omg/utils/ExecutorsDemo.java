package com.omg.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-poolz-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        List<Future<Long>> resultList = new ArrayList<Future<Long>>();
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyTask());
        }
    }


    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread name:"
                    + Thread.currentThread().getName());
            try {
                System.out.println("www");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    https://www.cnblogs.com/hapjin/p/7599189.html
}