RabbitMQ

    1、核心元素
    
        生产者（productor）
        交换机 (exchange)
        消息队列(queue)
        消费者(consumer)
        
     2、交换机的类型
        
        Direct
            RabbitMQ默认的交换机模式，也是最简单的模式。
            相当于一对一模式，一个消息被发送者发送后，会被转发到一个绑定的消息队列中，然后被一个接收者接收
            
        topic
            通配符+字符串模式
        
        headers
            规则匹配
        
        Fanout
            路由广播