package com.example.demo.test;

/**
 * @author cnh
 * @date 2021-12-21
 */
public class Demo {

    public static void main(String[] args) {

        DemoA demoA =new DemoA("222");


        change1(demoA);
        System.out.println(demoA);


    }

   static String change(String a){
        a =a+"222";
        return a;
    }

    static void change1(DemoA a){
        String mm = a.getMm();

        //System.out.println("-------"+a);

    }
}


final class  DemoA{

    DemoA(String mm){
        this.mm =mm;
    }

    private   String mm;

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getMm() {
        return mm;
    }

    @Override
    public String toString() {
        return "DemoA{" +
                "mm='" + mm + '\'' +
                '}';
    }
}
