package com.example.demo.java8;

import java.util.function.Consumer;

/**
 * @author cnh
 * @date 2022-02-15
 */
@FunctionalInterface
public interface ThrowExceptionFunction {

    void throwMessage(String message);

    //void trueOrFalseHandle(Runnable trueHandle,Runnable flaseHandle);

   // void presentOrElseHandle(Consumer action,Runnable emptyAction);

}
