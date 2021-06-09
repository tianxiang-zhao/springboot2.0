package com.tianxiang.springboot09.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;
import java.text.SimpleDateFormat;
@Service
public class MailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendSimpleEmail(String to,String subject,String text){
        //定制纯文本邮件信息 SimpleMailMessage
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom(this.from);
        message.setTo(to);
        message.setSubject(subject);//邮件的标题
        message.setText(text);//邮件内容
        try{
            //发送邮件
            javaMailSender.send(message);
            System.out.println("纯文本邮件发送成功");

        }catch (MailException e){
            System.out.println("纯文本邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }

    }

    public void sendEmail(String to,String subject,String text,
                              String filePath,String rscId,String rscPath) throws MessagingException {   //filePath代表附件地址，rscId表示静态资源唯一表示，rscPath表示静态资源地址。
            MimeMessage message = javaMailSender.createMimeMessage();
            //使用MimeMessageHelper 帮助类，并设置multipart多部件使用为ture
            MimeMessageHelper helper =new MimeMessageHelper(message,true);
            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);//邮件的标题
            helper.setText(text,true);

            //设置邮件静态资源
        FileSystemResource res=new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,res);

        //设置邮件附件
        FileSystemResource file=new FileSystemResource(new File(filePath));
        String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName,file);
        try{
            //发送邮件
            javaMailSender.send(message);
            System.out.println("邮件发送成功");

        }catch (MailException e){
            System.out.println("邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
        }


        public void sendEmailTempalte(String to,String subject,String content) throws MessagingException {
            MimeMessage message = javaMailSender.createMimeMessage();
            //使用MimeMessageHelper 帮助类，并设置multipart多部件使用为ture
            MimeMessageHelper helper =new MimeMessageHelper(message,true);
            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);//邮件的标题
            helper.setText(content,true);
            try{
                //发送邮件
                javaMailSender.send(message);
                System.out.println("模板邮件发送成功");

            }catch (MailException e){
                System.out.println("模板邮件发送失败"+e.getMessage());
                e.printStackTrace();
            }

        }
}
