package com.diancan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application {
    public  static  void main(String ...args) {
        SpringApplication.run(Application.class,args);
    }
}
