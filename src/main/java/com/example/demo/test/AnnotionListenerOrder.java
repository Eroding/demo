package com.example.demo.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author cnh
 * @date 2021-09-27
 */
@Component
public class AnnotionListenerOrder implements SmartApplicationListener {


    @Override
    @Async("customExexcutor")
    public void onApplicationEvent(ApplicationEvent event) {
        UserEvent userEvent = (UserEvent) event;
        System.out.println("注册");
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == UserEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == UserService.class;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
