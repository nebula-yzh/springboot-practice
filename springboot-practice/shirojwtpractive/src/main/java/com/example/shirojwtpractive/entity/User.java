package com.example.shirojwtpractive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Nebula
 * @date 2021/12/21 17:47
 * @description: 用户实体类
 */
@Data
@NoArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String rolePermission;
    
    public User(long id, String username, String password) {
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public User(long id, String username, String password,String permission) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.rolePermission=permission;
    }
}
