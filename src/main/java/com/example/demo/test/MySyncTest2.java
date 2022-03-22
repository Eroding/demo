package com.example.demo.test;

/**
 * @author cnh
 * @date 2021-11-22
 */
public class MySyncTest2 implements Runnable {

    private static int count;

    private static final Object lock = new Object();

    private static final int number = 100;


    @Override
    public void run() {
        while (count < number) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + count);
                count++;
                lock.notify();
                if(count<number){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MySyncTest2(),"偶数").start();
       // Thread.sleep(50);
        new Thread(new MySyncTest2(),"奇数").start();
    }
}
