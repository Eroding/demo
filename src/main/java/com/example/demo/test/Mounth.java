package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cnh
 * @date 2021-10-12
 */
@Async
public class Mounth {

    /**
     * 获取当前月有几个周，例如：2020/01，2022/11
     * @param mounth
     * @return
     */
    static List<String> getMounthWeek(String mounth){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        sdf1.setLenient(false);
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE");
        List<String> st = new ArrayList<>();
        List<Integer> a =new ArrayList<>();
        List<String> fianlSt = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            try {
                Date date = sdf1.parse(mounth + "/" + i);
                st.add(sdf1.format(date) + " : " + sdf2.format(date));
                a.add(i);
            } catch (ParseException e) {

            }
        }
        if (!CollectionUtils.isEmpty(st)) {
            Integer n = 0;
            for (String s1 : st) {
                if (s1.contains("日")) {
                    if (n == 0) {
                        fianlSt.add("第" + ++n + "周（" + mounth.substring(5,7) + "01" +"-"+ mounth.substring(5,7)+s1.substring(8, 10) + "）");
                    } else {
                        Integer ss = Integer.valueOf(s1.substring(8, 10));
                        Integer ss1 = ss - 6;
                        String m =ss1.toString();
                        if(Integer.valueOf(ss1)<10){
                            m = "0"+ss1.toString();
                        }
                        String m1 =ss.toString();
                        if(Integer.valueOf(ss)<10){
                            m1 = "0"+ss.toString();
                        }
                        fianlSt.add("第" + ++n + "周（" +mounth.substring(5,7)+ m + "-"+ mounth.substring(5,7)+m1 + "）");
                        Integer integer = a.stream().max(Integer::compare).get();
                        if((integer-ss)<7 && (integer-ss)>0){
                            fianlSt.add("第" + ++n + "周（" +mounth.substring(5,7)+ ++ss + "-"+ mounth.substring(5,7)+ integer+ "）");
                        }
                    }
                }
            }
        }
        return fianlSt;
    }
}
