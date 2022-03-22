package com.example.demo.designModel;

/**
 * @author cnh
 * @date 2022-03-16
 */
public class CPCNchannelPay extends AbstractBasePay{
    @Override
    void channlPay() {
        System.out.println("中金支付");
    }
    boolean isCheckAuth() {
        return false;
    }
}
