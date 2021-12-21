package com.example.shirojwtpractive.Service.impl;

import com.example.shirojwtpractive.Service.UserService;
import com.example.shirojwtpractive.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Nebula
 * @date 2021/12/21 17:55
 * @description: TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return new User(1,"nebula","123456","admin");

    }

    @Override
    public User findUserByUsername(String username) {
        return new User(2,"yzh","123456","admin");
    }
}
