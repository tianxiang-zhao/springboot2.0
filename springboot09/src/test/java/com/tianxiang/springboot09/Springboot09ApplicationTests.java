package com.tianxiang.springboot09;

import com.tianxiang.springboot09.Service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@SpringBootTest
class Springboot09ApplicationTests {
    @Autowired
     private  MailService mailService;


    @Test
    void contextLoads() {
        String to="1310138656@qq.com";
        String subject="Java邮件标题";
        String txt="Springboot 自定义邮件发送";
        mailService.sendSimpleEmail(to,subject,txt);
    }

    @Test
    void testEmail() throws MessagingException {
        String to="1310138656@qq.com";
        String subject="端午节的提前问候";

        //定义文件内容
        StringBuilder text=new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>祝大家端午节快乐！</h1>");
        //cid 为固定写法 rscId自定义资源的唯一表示
        String rscId="img001";
        text.append("<img src='cid:"+rscId+"'/></body>");
        text.append("</html>");
        //指定今天资源文件和附件路径
        String rscPath="F:\\duanwu.jpg";
        String filePath="F:\\duanwu.txt";
        //发送邮件
        mailService.sendEmail(to,subject,text.toString(),filePath,rscId,rscPath);

    }

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    void testEmailTemplate() throws MessagingException {
        String to="zy1091769374@sina.com";
        String subject="验证码";
        //使用邮件模板 定制邮件内容
        Context context=new Context();
        context.setVariable("username","Tom");
        context.setVariable("code","45789");
        //使用 TemplateEngine设置处理模板页面
        String emailContent=templateEngine.process("emailTemplate",context);
        //发送邮件
        mailService.sendEmailTempalte(to,subject,emailContent);
    }

}
