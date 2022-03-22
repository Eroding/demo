package com.example.demo.designModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Singleton {
    SINGLETON;


    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Singleton singleton1 = Singleton.SINGLETON;

     /*   log.info("------,{}",singleton.hashCode(),"*****,{}",singleton1.hashCode());*/
        System.out.println("--"+singleton.hashCode()+"~~"+singleton1.hashCode());

    }
}
