package com.example.demo.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cnh
 * @date 2021-11-15
 */
public class SingleDemo {


    private static SingleDemo singleDemo;

    private SingleDemo() {
    }


    public static SingleDemo getSingleDemo() {
        if (null == singleDemo) {
            synchronized (SingleDemo.class) {
                if(null == singleDemo){
                    singleDemo = new SingleDemo();
                }

            }

        }


        return singleDemo;
    }
}
