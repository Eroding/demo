package com.example.demo.test;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author cnh
 * @date 2021-11-11
 */
public class MyCompletableFutureDemo {





    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        CompletableFuture<Object> completableFuture =new CompletableFuture<>();

        new Thread(()-> {
            System.out.println("aaa");

           // completableFuture.complete("333");
        }).start();
      //  System.out.println(completableFuture.get());


        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            completableFuture.complete("wdnmd");
            return "test";
        });
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
        System.out.println(completableFuture.get());*/


        ThreadPoolExecutor poolExecutor =new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new MyRejected()
        );

        poolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("poolExecutor是否为守护线程"+Thread.currentThread().isDaemon());
                return null;
            }
        });



        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("lambda");
            System.out.println("supplyAsync是否为守护线程"+Thread.currentThread().isDaemon());

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("lambda is ok");
            return "result1";
        });



        final CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(" not lambda,用了线程池");

            System.out.println("supplyAsync是否为守护线程--------"+Thread.currentThread().isDaemon());


            return "result2";
        },poolExecutor);


        final CompletableFuture<Void> completableFuture3 = CompletableFuture.runAsync(()->{
            System.out.println("completableFuture3是否为守护线程--------"+Thread.currentThread().isDaemon());
                   try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable --------test");
        },poolExecutor);



        final CompletableFuture<Void> completableFuture4 = CompletableFuture.runAsync(()->{
            System.out.println("completableFuture4是否为守护线程--------"+Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable2222222222222 --------test");
        });



        System.out.println(completableFuture.get());
        System.out.println(completableFuture2.get());
        System.out.println(completableFuture3.get());
        System.out.println(completableFuture4.get());
        poolExecutor.shutdown();
       // completableFuture.join();
        System.out.println("finish");
    }
}





