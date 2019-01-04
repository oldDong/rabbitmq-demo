package com.dongzj.receiver.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/23
 * Time: 13:55
 */
@Service
public class HelloReceiver {

    @RabbitListener(queues = "queue")
    public void process(String str) {
        System.out.println("Receive: " + str);
    }

    @RabbitListener(queues = "topic.message")
    public void process1(String str) {
        System.out.println("message: " + str);
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String str) {
        System.out.println("messages: " + str);
    }

    @RabbitListener(queues = "fanout.A")
    public void processA(String str) {
        System.out.println("ReceiveA: " + str);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB: " + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC: " + str);
    }
}
