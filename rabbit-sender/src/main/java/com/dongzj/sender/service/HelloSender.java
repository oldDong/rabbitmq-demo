package com.dongzj.sender.service;

import com.dongzj.sender.vo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/23
 * Time: 13:48
 */
@Service
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        User user = new User();
        user.setUsername("lucia");
        user.setPassword("123456");
        template.convertAndSend("queue", user.toString());
    }

    public void sendMessage() {
        template.convertAndSend("exchange", "topic.message", "hello, rabbit");
    }

    public void sendMessages() {
        template.convertAndSend("exchange", "topic.messages", "hello hello, rabbit");
    }

    public void sendFanout() {
        template.convertAndSend("fanoutExchange", "", "今夜的星星已早睡");
    }
}
