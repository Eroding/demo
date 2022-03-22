package com.example.demo.java8;

import cn.hutool.core.util.StrUtil;

/**
 * @author cnh
 * @date 2022-02-15
 */
public class VUtils {


    public static ThrowExceptionFunction isTureOrFalse() {

   /*     return (trueHandle,falseHandle) -> {
            if (StrUtil.isBlank(str)) {  //str == null || str.length() == 0
                falseHandle.run();
            }else {
                trueHandle.accept(str);
            }
        };*/
        return (message) -> {
            if(true){
                throw new RuntimeException(message);
            }

        };
    }

}
