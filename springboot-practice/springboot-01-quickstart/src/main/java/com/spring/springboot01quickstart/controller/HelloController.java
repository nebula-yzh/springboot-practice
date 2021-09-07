package com.spring.springboot01quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZH.Y
 * 将@ResponseBody注解放在类外，表示该类的所有方法返回的数据直接写给浏览器(如果是对象还能转为json数据)
 * 注解@RestController 是将两个注解合在一起
 */
//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "quick start!";
    }
}
