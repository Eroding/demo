package com.example.demo.test;

import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cnh
 * @date 2021-10-28
 */
public class TestB {
    public static void main(String[] args) {

        BigDecimal subtract = new BigDecimal("80000");

        BigDecimal bigDecimal = new BigDecimal("120300000");



        BigDecimal divide = subtract.divide(bigDecimal, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));


        System.out.println(divide);

    }
}
