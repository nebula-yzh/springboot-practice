package com.example.shirojwtpractive.config.shiro;

import com.example.shirojwtpractive.Service.UserService;
import com.example.shirojwtpractive.entity.User;
import com.example.shirojwtpractive.util.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author Nebula
 * @date 2021/12/21 17:44
 * @description:
 * Realm中实现了shiro认证的主要功能，
 * 包括认证和鉴权两个方面
 */
@Component
public class JwtRealm extends AuthorizingRealm {

    @Autowired
    public UserService userService;

    /**
     * 必须重写此方法否则会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，
     * 权限认证
     * admin,管理员权限或其他权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("————权限认证————");
        //获取token
        String token = principalCollection.toString();
        //通过token获取用户名
        String username = JwtUtils.getClaimField(token,JwtUtils.ACCOUNT);
        System.out.println(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取当前用户的权限
        User user = userService.findUserByUsername(username);
        //可以添加单个权限，也可以添加多个（集合）
        simpleAuthorizationInfo.addRole(user.getRolePermission());
        simpleAuthorizationInfo.addStringPermission(user.getRolePermission());
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误则抛出异常
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token
        String token = (String) authenticationToken.getCredentials();
        //解密获得用户名
        String username = JwtUtils.getClaimField(token,JwtUtils.ACCOUNT);
        if (StringUtils.isEmpty(username)){
            throw new AuthenticationException("token认证失败！");
        }
        User user = userService.findUserByUsername(username);
        if (StringUtils.isEmpty(user)){
            throw new AuthenticationException("该用户不存在！");
        }

        return new SimpleAuthenticationInfo(token,token,"myRealm");
    }
}
