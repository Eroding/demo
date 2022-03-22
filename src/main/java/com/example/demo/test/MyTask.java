package com.example.demo.test;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @author cnh
 * @date 2021-10-29
 */

public class MyTask implements Runnable{

    private int taskId;

    private String taskName;

    public MyTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("taskId:"+taskId+"taskName:"+taskName);
        ThreadUtil.sleep(1000);
    }


    public static void main(String[] args) {





    }
}
