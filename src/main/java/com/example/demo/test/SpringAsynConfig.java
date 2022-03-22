package com.example.demo.test;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cnh
 * @date 2021-09-27
 */
@Configuration
@EnableAsync
public class SpringAsynConfig implements AsyncConfigurer {


    @Autowired
    CustomAsynExceptionHandler customAsynExceptionHandler;



    @Bean("customExexcutor")
    public ThreadPoolTaskExecutor asyncOperationExcuter() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setQueueCapacity(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(60); //s
        threadPoolTaskExecutor.setThreadNamePrefix("Thread-");
        threadPoolTaskExecutor.setThreadGroupName("Group-A");
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return customAsynExceptionHandler;
    }
}
