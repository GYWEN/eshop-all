package org.eshop.mq.mqBootStrap;


import org.eshop.mq.AspecJConfig;
import org.eshop.mq.ServiceTest;
import org.eshop.mq.event.CacheEvent;
import org.eshop.mq.event.eshopEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication(scanBasePackages = "org.eshop.mq")
@EnableAspectJAutoProxy
@ComponentScan("org.eshop.mq")
@Configuration
public class MqBootStrapApplicatopn {

    public static void main(String[] args) {

//        SpringApplication.run(MqBootStrapApplicatopn.class,args);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MqBootStrapApplicatopn.class);
        applicationContext.publishEvent(new eshopEvent("this s","123Taf"));
        applicationContext.publishEvent(new CacheEvent("123123"));
        ServiceTest test = (ServiceTest) applicationContext.getBean("serviceTest");


        test.get();

    }
}
