package com.example.demo.atomic;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cnh
 * @date 2021-11-22
 */
public class AtomicTest extends Thread {

    private String name;

    private LinkedList<Integer> appleBox;

    private Integer boxSize;

    private AtomicInteger appleCurrentNum;


    public AtomicTest(String name, LinkedList<Integer> appleBox, Integer boxSize, AtomicInteger appleCurrentNum) {
        this.name = name;
        this.appleBox = appleBox;
        this.boxSize = boxSize;
        this.appleCurrentNum = appleCurrentNum;
    }


    @Override
    public void run() {
        while (true){

            synchronized (appleBox){
                if(appleBox.size()<boxSize){
                    Integer apple = appleCurrentNum.addAndGet(1);
                    appleBox.addFirst(apple);
                    System.out.println(name+"生产者线程，生产编号"+apple+"当前"+appleBox.size());

                    try {
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    appleBox.notifyAll();

                    try {
                        appleBox.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        appleBox.notifyAll();
                    }


                }else {

                    try {
                        System.out.println(name+"生产者线程，满了,当前"+appleBox.size());
                        appleBox.wait();
                    } catch (InterruptedException e) {
                        appleBox.notifyAll();
                        e.printStackTrace();
                    }

                }
            }



        }
    }
}
