package com.tianxiang.springboot08;

import com.tianxiang.springboot08.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Springboot08ApplicationTests {
    @Resource
    private AmqpAdmin amqpAdmin;
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    void testPublisher(){
    User user=new User();
    user.setId(1);
    user.setUserName("飞机");
    // 第一个参数表示表示交换器，第二个表示路由键，第三个为传递的消息。
    rabbitTemplate.convertAndSend("fanout_exchange","",user);


    }

    @Test
    void contextLoads() {
        //1.定义一个fanout交换器
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));
        //2.定义两个默认持久化队列，分别是email和sms
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));//队列的名称
        amqpAdmin.declareQueue(new Queue("fanout_queue_sms"));
        //3.将队列与交换器绑定
        amqpAdmin.declareBinding(new Binding("fanout_queue_email",Binding.DestinationType.QUEUE,"fanout_exchange"," ",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_sms",Binding.DestinationType.QUEUE,"fanout_exchange"," ",null));

    }


    /**
     * 路由模式
     */
    @Test
    void testRouting(){

        rabbitTemplate.convertAndSend("routing_exchange","error_routing_key","routing send message error");
        rabbitTemplate.convertAndSend("routing_exchange","info_routing_key","routing send message success");

    }

    /**
     * 通配符模式
     */
    @Test
    void testTopic(){

//      //1.只发送邮件订阅用户消息
//        rabbitTemplate.convertAndSend("topic_exchange","info.email","topics send email message");
//
//        //2.只发送短信订阅用户消息
//        rabbitTemplate.convertAndSend("topic_exchange","info.sms","topics send sms message");

        //3.发送邮件和短信订阅用户消息
        rabbitTemplate.convertAndSend("topic_exchange","info.email.sms","topics send email and sms essage");
    }
}
