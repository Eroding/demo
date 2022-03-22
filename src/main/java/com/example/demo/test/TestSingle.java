package com.example.demo.test;

public enum TestSingle {
    //本身
 //   TEST_SINGLE2();

    TEST_SINGLE(500);

    int m;

  /*  TestSingle() {

    }*/

    TestSingle(int m) {
        this.m = m;
    }

    public int testA(int i) {
        return i;
    }


    public static void main(String[] args) {
        int i = TestSingle.TEST_SINGLE.testA(2);


        int m = TestSingle.TEST_SINGLE.m;
        System.out.println(m);
        

    }
}
