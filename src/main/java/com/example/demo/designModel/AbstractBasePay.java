package com.example.demo.designModel;

/**
 * @author cnh
 * @date 2022-03-16
 */
public abstract class AbstractBasePay implements BasePay {
    boolean isCheckAuth() {
        return true;
    }


    @Override
    public final void mobilePay() {

        if (isCheckAuth()) {
            checkAuth();
        }
        checkParam();
        chenckRisk();
        channlPay();

    }

    private void checkAuth() {
        System.out.println("支付权限校验");
    }

    abstract void channlPay();

    private void chenckRisk() {
        System.out.println("风控校验");
    }

    private void checkParam() {
        System.out.println("检查参数");
    }
}
