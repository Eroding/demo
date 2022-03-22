package com.example.demo.rocketmq;

import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author cnh
 * @date 2021-12-31
 */
public class ShunxuConsumer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer();


        //集群搭建地址
        defaultMQPushConsumer.setNamesrvAddr("服务器ip:端口号; 服务器ip:端口号");

        defaultMQPushConsumer.subscribe("base", "tag1");

        defaultMQPushConsumer.registerMessageListener(new MessageListenerOrderly() {


            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
           //消费者是多线程消费，一个队列使用一条线程去消费，消费方注册的监听器，用order类型
                for (MessageExt messageExt:list){
                    System.out.println(messageExt.getBody().toString());
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        defaultMQPushConsumer.start();
    }
}
