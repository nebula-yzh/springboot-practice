package com.example.swaggerpractice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nebula
 * @date 2021/12/20 18:18
 * @description: TODO
 */
@RestController
@Api("helloController")
public class HelloSwagger {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String helloSwagger(){
        return "Hello Swagger!";
    }
}
