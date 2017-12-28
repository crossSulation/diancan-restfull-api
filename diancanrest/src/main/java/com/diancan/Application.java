package com.diancan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com.diancan.configurations.mongoconfig","com.diancan.configurations","com.diancan"})
@EnableAutoConfiguration
public class Application {
    public  static  void main(String ...args) {
        SpringApplication.run(Application.class,args);
    }
}
