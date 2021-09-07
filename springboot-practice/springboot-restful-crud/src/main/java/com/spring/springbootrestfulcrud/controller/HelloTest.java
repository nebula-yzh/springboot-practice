package com.spring.springbootrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloTest {

    @ResponseBody
    @RequestMapping("/")
    public String retDash(){
        return "hello world!";
    }
}
