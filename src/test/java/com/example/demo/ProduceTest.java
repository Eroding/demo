package com.example.demo;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author cnh
 * @date 2022-01-10
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplicationTests.class})
public class ProduceTest {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendMessage(){
        rocketMQTemplate.convertAndSend("springboot-rocketmq","mqProduce");
    }
}
