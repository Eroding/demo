package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author cnh
 * @date 2021-09-27
 */
@Service
public class UserService {



    @Autowired
    private ApplicationEventPublisher applicationContext;

    public void register(UserVo userVo) {
        applicationContext.publishEvent(new UserEvent(this, userVo));
    }

    public void getTicket(int m) {
        //sql中取出的值
        int ticket = 3;
        int i = ticket - m;


    }
}
