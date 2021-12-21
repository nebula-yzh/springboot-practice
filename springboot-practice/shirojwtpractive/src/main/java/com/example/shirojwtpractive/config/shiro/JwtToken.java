package com.example.shirojwtpractive.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Nebula
 * @date 2021/12/21 15:05
 * @description: 封装JwtToken来替换shiro的原生token
 */
public class JwtToken implements AuthenticationToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
