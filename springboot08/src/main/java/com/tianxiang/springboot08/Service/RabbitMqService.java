package com.tianxiang.springboot08.Service;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    /**
     * 通配符模式消息接受，进行邮件业务订阅处理
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic_queue_email"),
            exchange = @Exchange(value = "topic_exchange",type = "topic"),
            key = "info.#.email.#"))
    public void topicConsumerEmail(String message){
        System.out.println("接受到邮件订阅处理消息:"+message);
    }

    /**
     * 通配符模式消息接受，进行短息业务订阅处理
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic_queue_sms"),
            exchange = @Exchange(value = "topic_exchange",type = "topic"),
            key = "info.#.sms.#"))
    public void topicConsumerSms(String message){
        System.out.println("接受到短信订阅处理消息:"+message);
    }











    /***
     * 路由消息模式处理error级别的日志信息
     * @param message
     */

    @RabbitListener(bindings = @QueueBinding(value = @Queue("routing_queue_error"),
            exchange = @Exchange(value = "routing_exchange",type = "direct"),
            key = "error_routing_key"))
    public void routingConsumerError(String message){
        System.out.println("接收到的error级别的日志消息:"+message);
    }

    /***
     * 路由消息模式处理info、error、warn级别的日志信息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue("routing_queue_all"),
            exchange = @Exchange(value = "routing_exchange",type = "direct"),
            key ={"error_routing_key","info_routing_key","warning_routing_key"}))
    public void routingConsumerAll(String message){
        System.out.println("接收到的日志消息:"+message);
    }











    /**
     * Publish/Subscribe工作模式，处理邮件业务。
     * @param message
     */
    @RabbitListener(queues = "fanout_queue_email")
    public void pubConsumerEmail(Message message){
        byte[] body=message.getBody();
        String s=new String(body);
        System.out.println("邮件业务接收到消息："+s);
    }

    /**
     * Publish/Subscribe工作模式，处理短息业务。
     * @param message
     */
    @RabbitListener(queues = "fanout_queue_sms")
    public void pubConsumerSms(Message message){
        byte[] body=message.getBody();
        String s=new String(body);
        System.out.println("短信业务接收到消息："+s);
    }




}
