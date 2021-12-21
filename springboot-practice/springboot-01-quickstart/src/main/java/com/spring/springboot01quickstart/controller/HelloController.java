package com.spring.springboot01quickstart.controller;

import com.spring.springboot01quickstart.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZH.Y
 * 将@ResponseBody注解放在类外，表示该类的所有方法返回的数据直接写给浏览器(如果是对象还能转为json数据)
 * 注解@RestController 是将两个注解合在一起
 */
//@ResponseBody
@Controller
//@RestController
public class HelloController {

    @Autowired
    Person person;

    @GetMapping(value = {"/","/home"})
    public String homePage(){
        return "home";
    }

    @ResponseBody
    @RequestMapping("/person")
    public Person person(@RequestParam("name") String name,@RequestParam("weight") Integer weight ) {
        System.out.println(name+weight);
        return person;
    }




}
