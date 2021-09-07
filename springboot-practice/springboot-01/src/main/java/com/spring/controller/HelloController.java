package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZH.Y
 * 一个controller类，测试springboot的请求响应，通过注解表示
 * 注解@RequestMapping 表示请求的地址
 * 注解@ResponseBody 表示响应的数据
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

}
