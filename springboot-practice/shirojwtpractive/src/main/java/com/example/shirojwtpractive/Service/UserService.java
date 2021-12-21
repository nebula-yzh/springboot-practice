package com.example.shirojwtpractive.Service;

import com.example.shirojwtpractive.entity.User;

/**
 * @author Nebula
 * @description: TODO
 * @date 2021/12/21 17:52
 */
public interface UserService {
    /**
     * 根据用户名跟密码查找用户
     * @param username 用户名
     * @param password 密码
     * @return 返回用户
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
