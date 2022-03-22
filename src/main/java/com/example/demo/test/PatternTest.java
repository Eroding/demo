package com.example.demo.test;

import java.util.regex.Pattern;

/**
 * @author cnh
 * @date 2021-10-13
 */
public class PatternTest {

    private static final Pattern PATTERN = Pattern.compile("^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,2})?$");

    public static void main(String[] args){

        System.out.println("0 === " + PATTERN.matcher("0").matches());
        System.out.println("5. === " + PATTERN.matcher("5.").matches());
        System.out.println("5.1 === " + PATTERN.matcher("5.1").matches());
        System.out.println("5.12 === " + PATTERN.matcher("5.12").matches());
        System.out.println("5.123 === " + PATTERN.matcher("5.123").matches());
        System.out.println("0.12 === " + PATTERN.matcher("0.12").matches());

    }

}
