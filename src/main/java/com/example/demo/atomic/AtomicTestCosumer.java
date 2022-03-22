package com.example.demo.atomic;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cnh
 * @date 2021-11-22
 */
public class AtomicTestCosumer extends Thread {

    private String name;

    private LinkedList<Integer> appleBox;

    private Integer boxSize;


    public AtomicTestCosumer(String name, LinkedList<Integer> appleBox, Integer boxSize) {
        this.name = name;
        this.appleBox = appleBox;
        this.boxSize = boxSize;

    }


    @Override
    public void run() {
        while (true) {

            synchronized (appleBox) {
                if (appleBox.isEmpty()) {

                    System.out.println(name + "消费者线程，没有东西了");
                    try {
                        appleBox.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        appleBox.notifyAll();
                    }
                } else {

                    appleBox.notifyAll();
                    try {
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer integer = appleBox.removeLast();
                    System.out.println(name + "消费者线程，消费编号" + integer + "当前" + appleBox.size());
                    try {
                        //消费之后立刻进入阻塞状态，让生产者生产
                        appleBox.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                        appleBox.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {


        LinkedList<Integer> appleBox = new LinkedList<>();
        Integer boxSize = 5;
        AtomicInteger initNum = new AtomicInteger(0);
        AtomicTest producer1 = new AtomicTest("P_1", appleBox, boxSize, initNum);
        AtomicTest producer2 = new AtomicTest("P_2", appleBox, boxSize, initNum);
        AtomicTest producer3 = new AtomicTest("P_3", appleBox, boxSize, initNum);
        AtomicTestCosumer consumer1 = new AtomicTestCosumer("C_1", appleBox, boxSize);
        AtomicTestCosumer consumer2 = new AtomicTestCosumer("C_2", appleBox, boxSize);
        AtomicTestCosumer consumer3 = new AtomicTestCosumer("C_3", appleBox, boxSize);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();

    }


}
