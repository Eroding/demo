package com.example.demo.test;

/**
 * @author cnh
 * @date 2021-11-22
 */
public class MySync implements Runnable {

    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();



    public static void main(String[] args) {

        MySync r1 = new MySync();
        MySync r2 = new MySync();
        r1.flag =1;
        r2.flag =0;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();



    }

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (o2) {
                System.out.println("Thread1 get Syn");
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (o1) {
                System.out.println("Thread2 get Syn");
            }
        }
    }
}
