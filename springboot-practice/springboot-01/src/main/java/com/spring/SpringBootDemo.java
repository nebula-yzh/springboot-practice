package com.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZH.Y
 * 注解 @SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用
 */
@SpringBootApplication
public class SpringBootDemo {
    public static void main(String[] args) {
        //spring应用启动
        SpringApplication.run(SpringBootDemo.class,args);
    }
}
