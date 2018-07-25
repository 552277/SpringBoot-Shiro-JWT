package com.example.SpringBootShiroJWT.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zhongweichang
 * @email 15090552277@163.com
 * @date 2018/7/25 下午1:21
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
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