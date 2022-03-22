package com.example.demo.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cnh
 * @date 2021-10-22
 */
public class Class3 {


    public static void main(String[] args) {

     /*   DecimalFormat df = new DecimalFormat("0.00");
        Integer a = 34;
        Integer b = 55;


        System.out.println(df.format((float) a * 100 / b));*/
//57.89
        BigDecimal a = new BigDecimal("33");
        BigDecimal b = new BigDecimal("0");
        System.out.println(returnPercent(a, b, "0.00",2));


     //   System.out.println(a.divide(b,4,BigDecimal.ROUND_HALF_UP));

    }


    /**
     * @param divisor    除数
     * @param dividend   被除数
     * @param returnType 想要返回的小数点位数
     * @param decimalType 想要返回的bigdecimal位数
     * @return
     */
    static String returnPercent(Object divisor, Object dividend, String returnType,Integer decimalType) {

        DecimalFormat df = new DecimalFormat(returnType);

        if (divisor == null || dividend == null) {
            return "0";
        }
        if (divisor instanceof Integer && dividend instanceof Integer) {
            float divisorFloat = Float.parseFloat(divisor.toString());
            int dividendInteger = Integer.parseInt(dividend.toString());
            if(divisorFloat ==0 || dividendInteger ==0){
                return "0";
            }else {
                return df.format(divisorFloat * 100 / dividendInteger);
            }
        } else if (divisor instanceof BigDecimal && dividend instanceof BigDecimal) {
            BigDecimal divisorBigDecimal = (BigDecimal) divisor;
            BigDecimal dividendBigDecimal = (BigDecimal) dividend;

            if (dividendBigDecimal.compareTo(new BigDecimal("0")) ==0 ) {
                return "0";
            }else {
                BigDecimal divide = divisorBigDecimal.divide(dividendBigDecimal, decimalType+2, BigDecimal.ROUND_HALF_UP);
                return String.valueOf(divide.floatValue() * 100);
            }
        }
        return "";
    }


}
