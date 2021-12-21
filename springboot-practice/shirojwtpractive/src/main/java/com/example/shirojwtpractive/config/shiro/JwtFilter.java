package com.example.shirojwtpractive.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Nebula
 * @date 2021/12/21 16:24
 * @description:
 * jwt过滤器 访问其他接口或资源时，判断有无token，根据有无token进行处理(在用户已经登录的情况下)
 * 验证从请求的header中取出的token信息
 */
@Slf4j
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {
    /**
     * 获取请求头中的key，可以在配置文件中配置，用@value
     * 也可以对key进行修改
     */
    public static final String ACCESS_TOKEN = "Access-Token";

    /**
     * 如果请求被允许正常通过过滤器，则返回true;
     * 如果请求应该由onAccessDenied(request,response,mappedValue)方法处理，则返回false。
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
        //1.判断请求头中是否有token
        if(isLoginAttempt(servletRequest,servletResponse)){
            //2.若存在token，执行登陆操作，检查token是否正确
            try {
                executeLogin(servletRequest,servletResponse);
                return true;
            } catch (Exception e) {
                log.error("token错误");
                throw new RuntimeException("Unauthorized access!");
            }

        }
        //如果请求头中不存在token，则可能是执行登陆操作，无需检查token，直接返回true
        return true;
    }

    /**
     * 重写登陆尝试
     * 判断请求头中是否有token
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(ACCESS_TOKEN);
        return token!=null;
    }

    /**
     * 执行登陆操作
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(ACCESS_TOKEN);
        JwtToken jwtToken = new JwtToken(token);
        //提交给realm进行登入，若有错误会抛出异常
        getSubject(request,response).login(jwtToken);
        //若没有抛出异常则代表登陆成功，返回true
        return true;
    }
}
