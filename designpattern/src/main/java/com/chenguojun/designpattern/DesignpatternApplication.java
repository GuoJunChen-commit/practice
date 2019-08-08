package com.chenguojun.designpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackages = {"com.chenguojun"})
@EnableScheduling
public class DesignpatternApplication {

    public static void main(String[] args) {

        SpringApplication.run(DesignpatternApplication.class, args);
    }

}
