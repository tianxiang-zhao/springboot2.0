package com.tianxiang.springboot09.Controller;

import com.tianxiang.springboot09.Service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Controller
public class MyController {
    @Autowired
    private MyAsyncService myAsyncService;

    @RequestMapping("/sendSMS")
    public String sendSMS(){
        System.out.println("主业务处理方法！");
        long startTime=System.currentTimeMillis();
        try {
            myAsyncService.sendSMS();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime= System.currentTimeMillis();
        System.out.println("主业务处理耗时"+(endTime-startTime));
        return "success.html";
    }

    @GetMapping("/statistics")
    public String statistics() throws InterruptedException, ExecutionException {
        System.out.println("主业务处理方法！");
        long startTime=System.currentTimeMillis();
        Future<Integer>futureA=myAsyncService.processA();
        Future<Integer>futureB=myAsyncService.processB();
        int total=futureA.get()+futureB.get();
        System.out.println("异步任务数据统计结果汇总："+total);
        long endTime= System.currentTimeMillis();
        System.out.println("主业务处理耗时"+(endTime-startTime));
        return "success.html";
    }

}
