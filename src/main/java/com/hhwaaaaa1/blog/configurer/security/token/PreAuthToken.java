package com.hhwaaaaa1.blog.configurer.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreAuthToken extends UsernamePasswordAuthenticationToken {
    public PreAuthToken(Object token) {
        super(token, null);
    }

    public String getToken(){
        return (String)super.getPrincipal();
    }
}
