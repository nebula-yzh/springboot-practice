package com.example.shirojwtpractive.controller;

import com.example.shirojwtpractive.Service.UserService;
import com.example.shirojwtpractive.entity.User;
import com.example.shirojwtpractive.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nebula
 * @date 2021/12/21 19:04
 * @description: TODO
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map login(@Validated @RequestParam("username") String username,
                     @Validated @RequestParam("password") String password,
                     HttpServletResponse response){
        User user = userService.findUserByUsername(username);
        if (user==null){
            System.out.println("error");
        }
        String token = JwtUtils.sign(username,password);
        response.setHeader("Access-Token", token);
        Map<String, String> map = new HashMap<>();
        map.put("Access-Token",token);
        return map;
    }



}
