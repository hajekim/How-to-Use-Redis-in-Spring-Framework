package com.memorynotfound;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageProducer {

    public static void main(String... args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        RedisService redisService = ctx.getBean(RedisService.class);
        
        for(int i=1; i<10; i++) {
        redisService.setValue("key"+i, "hello world!"+i);
        System.out.println("message: " + redisService.getValue("key"+i));
        }
    }
}
