package com.example.shirojwtpractive.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Nebula
 * @date 2021/12/21 15:12
 * @description: JWT工具类，用来对token进行操作
 */
@Component
public class JwtUtils {
    public static final String ACCOUNT = "username";
    /**
     * token到期时间，7天 60*60*24*7=604800，单位为秒，可以在配置文件中配置
     */
    public static final long EXPIRE_TIME = 604800;

    /**
     * 根据转换的密码与当前用户名生成jwt校验器，校验传入的token是否正确
     * 并获取全部的token信息
     * 使用的secret也可以唯一定义，使用一个(单独定义)
     * @param token 传入token
     * @param username 用户名
     * @param secret 密码
     * @return 返回token全部信息
     */
    public static DecodedJWT verify(String token, String username, String secret){
        //使用sha256算法对密码进行进行转换
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //根据转换的密码，与当前用户名，生成jwt校验器
        JWTVerifier verifier = JWT.require(algorithm)
                //用户名
                .withClaim(ACCOUNT,username)
                .build();
        //对传入的token进行校验
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取token单个信息，指定字段的信息
     * @param token token
     * @param claim 指定字段
     * @return 返回指定字段信息
     */
    public static String getClaimField(String token, String claim){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(claim).asString();
    }

    /**
     * 生成token，附带用户信息及过期时间签名
     * @param username 用户名
     * @param secret 密码
     * @return token
     */
    public static String sign(String username, String secret){
        //单位为ms
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME*1000);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(ACCOUNT,username)
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
