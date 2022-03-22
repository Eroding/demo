package com.example.demo.dly;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cnh
 * @date 2022-02-17
 */
public class Test {
    public static void main(String[] args) {
/*        boolean b = Stream.of(2,4,6,8,9,10,12).allMatch(p -> {
            System.out.println(p);
            return p % 2 == 0;});
        System.out.println(JSONObject.toJSONString(b));*/
        List<Integer> list = Arrays.asList(2, 4,4, 6, 8, 10, 12);
        list.stream().allMatch(p->{
            System.out.println(p);
            return p % 2 ==0;

        });

        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
