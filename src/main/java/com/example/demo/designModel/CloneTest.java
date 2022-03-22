package com.example.demo.designModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cnh
 * @date 2022-03-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloneTest implements Cloneable{

    private String name;
    private int age;
    private Student student;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest s1=new CloneTest("zfliu",18,new Student("nihao"));
        System.out.println("S1的姓名:"+s1.getName()+",年龄："+s1.getAge());


        //Object clone = s1.clone();
        CloneTest clone1 = (CloneTest) s1.clone();
        System.out.println("S2的姓名:"+clone1.getName()+",年龄："+clone1.getAge());

        //clone1.setStudent(new Student("CNH"));

        CloneTest s3=s1;
        System.out.println("S3的姓名:"+s3.getName()+",年龄："+s3.getAge());

        s3.setAge(20);
        s3.setName("liuzf");
        System.out.println("-----"+clone1.hashCode()+"----------"+s1.hashCode());

        System.out.println("-----"+clone1.getStudent().hashCode()+"----------"+s1.getStudent().hashCode());

        System.out.println("-----"+clone1.getName().hashCode()+"----------"+s1.getName().hashCode());

        System.out.println("S1的姓名:"+s1.getName()+",年龄："+s1.getAge()+"ssss"+s1.getStudent().getUserName());
        System.out.println("S2的姓名:"+clone1.getName()+",年龄："+clone1.getAge()+"ssss"+clone1.getStudent().getUserName());
       // System.out.println("S3的姓名:"+s3.getName()+",年龄："+s3.getAge()+"ssss"+s3.getStudent().getUserName());

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private String userName;
}
