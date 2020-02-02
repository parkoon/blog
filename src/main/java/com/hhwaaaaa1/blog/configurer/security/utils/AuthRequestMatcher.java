package com.hhwaaaaa1.blog.configurer.security.utils;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class AuthRequestMatcher implements RequestMatcher {
    private OrRequestMatcher orRequestMatcher;
    private OrRequestMatcher skipOrRequestMatcher;

    public AuthRequestMatcher(List<String> orRequestMatcher, List<String> skipOrRequestMatcher) {
        this.orRequestMatcher = new OrRequestMatcher(
                orRequestMatcher.stream().map(
                        p -> new AntPathRequestMatcher(p)
                ).collect(
                        Collectors.toList()
                )
        );

        this.skipOrRequestMatcher = new OrRequestMatcher(
                skipOrRequestMatcher.stream().map(
                        p -> new AntPathRequestMatcher(p)
                ).collect(
                        Collectors.toList()
                )
        );
    }

    @Override
    public boolean matches(HttpServletRequest httpServletRequest) {
        return orRequestMatcher.matches(httpServletRequest) && !skipOrRequestMatcher.matches(httpServletRequest);
    }
}