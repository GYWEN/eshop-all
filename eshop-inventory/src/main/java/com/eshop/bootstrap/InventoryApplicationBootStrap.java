package com.eshop.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * 启动类
 */
@SpringBootApplication(scanBasePackages = "com.eshop")
public class InventoryApplicationBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplicationBootStrap.class,args);
//        SpringApplication application = new SpringApplication(InventoryApplicationBootStrap.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

    }
}
