package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnh
 * @date 2021-10-08
 */
public class BreakCon {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for(
                int i = 0;
                i<10;i++)

        {
            if (i == 3) continue; //跳出循环，直接返回方法
            integers.add(i);
            System.out.println(i);
        }

        System.out.println("--------------------------");
        for(
                int item :integers)

        {
            System.out.println("mmmmm"+item);
        }
    }

}
