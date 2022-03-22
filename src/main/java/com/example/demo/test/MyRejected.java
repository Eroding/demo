package com.example.demo.test;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *拒绝策略
 * @author cnh
 * @date 2021-10-29
 */
public class MyRejected implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        MyTask r1 = (MyTask) r;
        System.out.println(r1.getTaskName()+"----------------");


    }
}
