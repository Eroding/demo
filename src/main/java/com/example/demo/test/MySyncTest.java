package com.example.demo.test;

/**
 * The type My sync test.
 *
 * @author cnh
 * @date 2021 -11-22
 */
public class MySyncTest {

    private static int count;

    private static final Object lock = new Object();

    private static final int number = 100;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Thread(() -> {

            while (count < number) {
                synchronized (lock) {
                    if ((count % 2) == 0) {
                        System.out.println(Thread.currentThread().getName() + "" + count);
                        count++;
                    }
                }
             //   System.out.println("偶数拿到了锁");
            }
        }, "偶数").start();

        new Thread(() -> {

            while (count < number) {
                synchronized (lock) {
                    if ((count % 2) == 1) {
                        System.out.println(Thread.currentThread().getName() + "" + count);
                        count++;
                    }
                }
            }
        }, "奇数").start();

    }

}
