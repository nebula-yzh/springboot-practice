package com.example.shirojwtpractive.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nebula
 * @date 2021/12/21 19:26
 * @description: TODO
 */
@RestController
public class TestController {

    @GetMapping("/test1")
    @RequiresRoles(value = "admin")
    public String test(){
        return "test1";
    }

    @GetMapping("/test2")
    @RequiresPermissions("admin")
    public String test2(){
        return "test2";
    }

    @GetMapping("/test3")
    @RequiresRoles("admin")
    @RequiresPermissions("admin")
    public String test3(){
        return "test3";
    }

    @GetMapping("test4")
    /**
     * 需要登陆
     */
    @RequiresAuthentication
    public String test4(){
        return "test4";
    }
}
