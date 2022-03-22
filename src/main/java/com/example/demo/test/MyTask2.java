package com.example.demo.test;

import java.util.concurrent.*;

/**
 * @author cnh
 * @date 2021-10-29
 */
public class MyTask2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ThreadPoolExecutor poolExecutor =new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new MyRejected()
        );


        poolExecutor.execute(new MyTask(1,"任务1"));
        poolExecutor.submit(()->{
            return "aaaaa";
        });
        boolean done = poolExecutor.submit(() -> {
            return "aaaaa";
        }).isDone();




       /* System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());

        poolExecutor.execute(new MyTask(2,"任务2"));
        System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());

        poolExecutor.execute(new MyTask(3,"任务3"));
        System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());

        poolExecutor.execute(new MyTask(4,"任务4"));
        System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());

        poolExecutor.execute(new MyTask(5,"任务5"));
        System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());

        poolExecutor.execute(new MyTask(6,"任务6"));
        System.out.println(poolExecutor.getActiveCount()+poolExecutor.getCorePoolSize()+poolExecutor.getPoolSize()+poolExecutor.getQueue().size());*/



    }
}
