package com.example.demo.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author cnh
 * @date 2021-12-31
 */
public class ShunxuProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();

        //集群搭建地址
        defaultMQProducer.setNamesrvAddr("服务器ip:端口号; 服务器ip:端口号");

        defaultMQProducer.start();

        //有顺序的集合消息

        List<OrderStep> list = OrderStep.buildOrders();


        for (int i = 0; i < list.size(); i++) {

            String body = list.get(i) + "";
            Message msg = new Message("base", "tag1", "i" + i, body.getBytes());

            defaultMQProducer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                  //怎么选择消息队列
                    long orderId = (long)o;
                    long index = orderId% list.size();
                    return list.get((int)index);
                }
            },list.get(i).getOrderId());

        }
    }
}
