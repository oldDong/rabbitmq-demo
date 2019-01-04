package com.dongzj.receiver.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 接收者配置
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/23
 * Time: 13:54
 */
@Configuration
public class ReceiverConf {

    /**
     * direct模式
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    /**
     * topic转发模式
     *
     * @return
     */
    @Bean(name = "message")
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean(name = "messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
    }

    /**
     * 路由广播
     * Fanout Exchange模式
     *
     * @return
     */
    @Bean(name = "Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean(name = "Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean(name = "Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        //配置广播路由器
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
