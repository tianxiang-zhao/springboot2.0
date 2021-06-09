package com.tianxiang.springboot09.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    private Integer count1=1;
    private Integer count2=1;
    private Integer count3=1;
    @Scheduled(fixedRate=60000)
    public void scheduledTaskInmediately(){
        System.out.println(String.format("fixeRate第%s次执行，当前时间为：%s",count1++,dateFormat.format(new Date())));
    }
    @Scheduled(fixedDelay=60000)
    public void scheduledTaskAfterSleep() throws InterruptedException {
        System.out.println(String.format("fixeDelay第%s次执行，当前时间为：%s",count2++,dateFormat.format(new Date())));
        Thread.sleep(10000);
    }
    @Scheduled(cron="0 * * * * *")  //只有正分时在执行
    public void scheduledTaskCorn() throws InterruptedException {
        System.out.println(String.format("Corn第%s次执行，当前时间为：%s",count3++,dateFormat.format(new Date())));

    }
}
