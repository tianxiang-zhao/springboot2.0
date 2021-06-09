package com.tianxiang.springboot09.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.concurrent.Future;

@Service
public class MyAsyncService {


    @Async  //表明该方法是一个异步方法。
    public void sendSMS() throws InterruptedException {
        System.out.println("调用短信业务处理方法！");
        long startTime=System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime= System.currentTimeMillis();
        System.out.println("短信业务处理耗时"+(endTime-startTime));

    }

    @Async
    public Future<Integer>processA() throws InterruptedException {
        System.out.println("开始分析业务A");

        long startTime=System.currentTimeMillis();
        Thread.sleep(5000);
        int count=12345;
        long endTime= System.currentTimeMillis();
        System.out.println("业务A处理耗时"+(endTime-startTime));
        return new AsyncResult<Integer>(count);
    }

    @Async
    public Future<Integer>processB() throws InterruptedException {
        System.out.println("开始分析业务B");

        long startTime=System.currentTimeMillis();
        Thread.sleep(5000);
        int count=654321;
        long endTime= System.currentTimeMillis();
        System.out.println("业务B处理耗时"+(endTime-startTime));
        return new AsyncResult<Integer>(count);
    }

}
