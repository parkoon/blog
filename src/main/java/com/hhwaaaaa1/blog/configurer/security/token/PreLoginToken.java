package com.hhwaaaaa1.blog.configurer.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreLoginToken extends UsernamePasswordAuthenticationToken {
    public PreLoginToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public String getUserId(){
        return (String)super.getPrincipal();
    }

    public String getUserPassword(){
        return (String)super.getCredentials();
    }
}
