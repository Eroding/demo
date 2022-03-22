package com.example.demo.designModel;

/**
 * @author cnh
 * @date 2022-03-16
 */
public class TestPay {
    public static void main(String[] args) {
        System.out.println("--中金支付start");
        BasePay pay1 = new CPCNchannelPay();
        pay1.mobilePay();
        System.out.println("--中金支付end");


        System.out.println("--阿里paystart");
        BasePay pay2 = new AliChannelPay();
        pay2.mobilePay();
        System.out.println("--阿里payend");

    }
}
