package com.example.demo.test;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author cnh
 * @date 2021-12-10
 */
public class FilterDemo2 {


    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap =new ConcurrentHashMap();
        String s = concurrentHashMap.putIfAbsent("1", "2");

        String s1 = concurrentHashMap.putIfAbsent("1", "3");
        System.out.println(s1);




    }


}
