package com.hhwaaaaa1.blog.configurer.security.tokens;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class PostAuthToken extends UsernamePasswordAuthenticationToken {
    public PostAuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
