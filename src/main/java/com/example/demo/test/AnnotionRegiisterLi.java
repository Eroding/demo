package com.example.demo.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author cnh
 * @date 2021-09-27
 */
@Component
public class AnnotionRegiisterLi implements ApplicationListener<UserEvent> {


    @Override
    public void onApplicationEvent(UserEvent event) {

    }
}
