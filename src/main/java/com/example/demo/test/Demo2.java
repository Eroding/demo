package com.example.demo.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cnh
 * @date 2022-01-10
 */
@Data
@Builder
@NoArgsConstructor
public class Demo2 {


    @Data
    @Builder
    @NoArgsConstructor
    static class Student {//只是为了方便演示

        private Integer id;
        private String name;
        private String grade;


        public Student(Integer id, String name, String grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }

        public static void main(String[] args) {
//            Student student =new Student();
//            System.out.println(BeanUtil.isEmpty(student ));

            String java = new String("java");
            java.intern();

            System.out.println("java"==java);
          /*  String st = "RGssss";
            System.out.println(st.contains("RG"));*/
          /*  System.out.println(StrUtil.isEmpty(st));
            System.out.println(StrUtil.isBlank(st));*/

//            System.out.println(ObjectUtil.equals(3, a.size()));
            ;
            //测试数据，可以看到顺序是乱的。

      /*      String createTime = null;
            System.out.println(DateUtil.parse(createTime, DatePattern.NORM_DATETIME_PATTERN));*/
           /* System.out.println(DateUtil.beginOfDay(new Date()));
            System.out.println(DateUtil.endOfDay(new Date()));*/
            //   System.out.println(DateUtil.offsetDay(new Date(), 0));
            //  System.out.println(DateUtil.endOfDay(new Date()).offset(DateField.MONTH, -999));

            //   DateTime dateTime = DateUtil.endOfDay(DateUtil.offset(new Date(), DateField.DAY_OF_MONTH, 1));
            //    System.out.println(dateTime);


            // System.out.println(DateUtil.nextMonth());

          /*  System.out.println(DateUtil.endOfDay(DateUtil.nextMonth()).offset(DateField.MILLISECOND, -999));
            Date ehdTime = DateUtil.endOfMonth(new Date()).offset(DateField.MILLISECOND, -999);
            Date startTime = DateUtil.beginOfDay(DateUtil.offsetDay(dateTime, -5));
            System.out.println(startTime);*/

     /*   Date date = new Date();
        System.out.println(new Date());

        System.out.println(DateUtil.offsetSecond(new Date(),1));*/


            //按编号升序(默认)
//        List<Student> collect1 = user.stream().sorted(Comparator.comparingInt(Student::getId)).collect(Collectors.toList());
//        //遍历输出
//        System.out.println("编号升序");
//        collect1.forEach(System.out::println);
//        System.out.println("===========================================================================");
//
//        //按年级升序(默认)
//        List<Student> collect = user.stream()
//                .sorted((o1, o2) -> Collator.getInstance(Locale.TRADITIONAL_CHINESE).compare(o1.getGrade(),o2.getGrade())).collect(Collectors.toList());
//        //遍历输出
//        System.out.println("中文升序");
//        collect.forEach(System.out::println);
//        System.out.println("===========================================================================");
//
//        //按编号降序
//        List<Student> collect2 = user.stream().sorted((o1, o2) -> o2.getId() - o1.getId()).collect(Collectors.toList());
//        //遍历输出
//        System.out.println("编号降序");
//        collect2.forEach(System.out::println);
//        System.out.println("===========================================================================");
//
//        //按年级降序
//        List<Student> collect3 =
//                user.stream().sorted((o1, o2) -> Collator.getInstance(Locale.TRADITIONAL_CHINESE).compare(o2.getGrade(),o1.getGrade())).collect(Collectors.toList());
//        //遍历输出
//        System.out.println("中文降序");
//        collect3.forEach(System.out::println);
//
////按中文
//       List<Student> collect4 =
//                user.stream().sorted((o1, o2) -> Collator.getInstance(java.util.Locale.CHINA).compare(o1.getName(),o2.getName())).collect(Collectors.toList());
//        //遍历输出
//     /*   user.sort(Comparator.comparing(Student::getName).reversed());
//
//        for (Student student : user) {
//            System.out.println(student);
//        }*/
//        //遍历输出
//
//        collect4.add(0,null);
//
//        System.out.println("中文升序");
//
//        collect4.forEach(System.out::println);

//            ArrayList<String> list = CollUtil.newArrayList("陈", "彭", "安", "徐");
//        user.sort((n1, n2) -> {
//                Collator collator = Collator.getInstance(Locale.CANADA);
//                return collator.compare(n1.getName(), n2.getName());
//            });

            // Collator collator = Collator.getInstance();


/*        user.sort(Comparator.comparing(Student::getName,
                Comparator.nullsLast(String::compareTo)).reversed());*/

            // user.sort(Comparator.nullsLast((u1, u2) -> collator.compare(u1.getName(), u2.getName())));

      /*  user.sort((u1,u2)-> collator.compare(u1.getName(),u2.getName()));

        Student student =new Student(-1,"陈南海","333");
        user.add(0,student);

        user.forEach(System.out::println);*/


        }

        static Object notNull(Integer id) {
            //Assert.notNull(id,"bunen");
            return
                    ObjectUtils.nullSafeHashCode(id);
        }
    }
}
