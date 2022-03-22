package com.example.demo.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cnh
 * @date 2021-10-22
 */

public class Class1 {


    String user;
    List<Class1> children;

  /*  public Class1(String user, List<Class1> children) {
        this.user = user;
        this.children = children;
    }*/

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Class1> getChildren() {
        return children;
    }

    public void setChildren(List<Class1> children) {
        this.children = children;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        DateTime beginOfMonth = DateUtil.beginOfMonth(DateUtil.parse("2021-10", "yyyy-MM"));
        System.out.println(beginOfMonth);


        HashMap<Integer,String> hashMap = new HashMap(2,1.5f);
        hashMap.put(5,"c");
        hashMap.put(7,"c");
        hashMap.put(3,"c");

        new Thread(() -> {
            hashMap.put(15,"D");
            System.out.println("A");
        },"Thread1").start();

        new Thread(() -> {
            hashMap.put(1,"D");
            System.out.println("C");
        },"Thread2").start();

      /*  ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects.isEmpty());

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        DecimalFormat df1 = new DecimalFormat("0.00");



        BigDecimal areaTarget =new BigDecimal("55") ;
        BigDecimal areaReach = new BigDecimal("5") ;

        BigDecimal divide1 = areaReach.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_DOWN);
        System.out.println(String.valueOf(divide1));
        BigDecimal divide = areaReach.divide(areaTarget, 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(String.valueOf(divide));
        String str = df1.format(divide.multiply(new BigDecimal("100")));
        System.out.println("////"+str);

        String format = percent.format(divide.doubleValue());
        System.out.println("~~~~~~~"+format);
        float v = divide.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println("111111~~~~~~~"+v);
        String a = (areaTarget.compareTo(new BigDecimal("0")) != 0) ? String.valueOf(areaReach.divide(areaTarget, 4, BigDecimal.ROUND_HALF_UP).floatValue() * 100) : "0";
        System.out.println("------"+a);*/
    }
}
