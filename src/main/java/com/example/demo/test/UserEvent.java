package com.example.demo.test;

import org.springframework.context.ApplicationEvent;

/**
 * @author cnh
 * @date 2021-09-27
 */
public class UserEvent extends ApplicationEvent {

    private UserVo userVo;

    public UserEvent(Object source,UserVo userVo) {
        super(source);
        this.userVo =userVo;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
