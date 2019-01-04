package com.dongzj.sender;

import com.dongzj.sender.service.HelloSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/23
 * Time: 13:50
 */
public class TestRabbitMQ extends RabbitSenderApplicationTests {

    @Autowired
    private HelloSender sender;

    @Test
    public void testRabbit() {
        sender.send();
    }

    @Test
    public void testMessage() {
        sender.sendMessage();
    }

    @Test
    public void testMessages() {
        sender.sendMessages();
    }

    @Test
    public void testFanout() {
        sender.sendFanout();
    }
}
