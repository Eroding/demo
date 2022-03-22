package com.example.demo.java8;

/**
 * @author cnh
 * @date 2022-02-15
 */
public class Test {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        VUtils.isTureOrFalse().throwMessage("报错");
    }
}
