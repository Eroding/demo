package com.example.demo.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author cnh
 * @date 2021-12-30
 */
public class producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        TransactionMQProducer defaultMQProducer = new TransactionMQProducer();

        //集群搭建地址
        defaultMQProducer.setNamesrvAddr("服务器ip:端口号; 服务器ip:端口号");

        //增加成事务类型的消息
        defaultMQProducer.setTransactionListener(new TransactionListener() {


            //执行
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {


                return null;
            }


            //检查
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                return null;
            }
        });






        defaultMQProducer.start();

        for (int i = 0; i < 10; i++) {

            Message msg = new Message("base", "tag1", ("hello" + i++).getBytes(StandardCharsets.UTF_8));

            //异步消息
          /*   defaultMQProducer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("ok");
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("error");
                }
            });*/
          /*  send.getMsgId();
            String offsetMsgId = send.getOffsetMsgId();
        }*/
            //事务消息

            defaultMQProducer.sendMessageInTransaction(msg,null);
            //线程睡眠1s
            TimeUnit.SECONDS.sleep(1);

        }
    }
}
