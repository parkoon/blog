package com.hhwaaaaa1.blog.configurer.security.filter;

import com.hhwaaaaa1.blog.configurer.security.constraint.SecurityConstraint;
import com.hhwaaaaa1.blog.configurer.security.token.PreAuthToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {
    public static AuthFilter.AuthFilterBuilder builder(AuthenticationManager authenticationManager) {
        return new AuthFilter.AuthFilterBuilder(authenticationManager);
    }


    protected AuthFilter(AuthFilter.AuthFilterBuilder authFilterBuilder) {
        super(authFilterBuilder.requestMatcher);
        super.setAuthenticationManager(authFilterBuilder.authenticationManager);
        super.setContinueChainBeforeSuccessfulAuthentication(authFilterBuilder.continueChainBeforeSuccessfulAuthentication);

        this.setAuthenticationSuccessHandler(authFilterBuilder.authenticationSuccessHandler);
        this.setAuthenticationFailureHandler(authFilterBuilder.authenticationFailureHandler);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = httpServletRequest.getHeader(SecurityConstraint.TOKEN_NAME);

        try {
            token = token.substring(SecurityConstraint.AUTH_PREFIX.length());
        } catch (Exception e) {
            new RuntimeException("invalid token information!");
        } finally {
            this.logger.debug("token: " + token);
        }

        return super.getAuthenticationManager().authenticate(new PreAuthToken(token));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }

    public static class AuthFilterBuilder {
        private AuthenticationManager authenticationManager;
        private RequestMatcher requestMatcher;
        private AuthenticationSuccessHandler authenticationSuccessHandler;
        private AuthenticationFailureHandler authenticationFailureHandler;
        private boolean continueChainBeforeSuccessfulAuthentication = false;


        private AuthFilterBuilder() {
        }

        private AuthFilterBuilder(AuthenticationManager authenticationManager) {
            this.authenticationManager = authenticationManager;
        }


        public RequestMatcher getRequestMatcher() {
            return requestMatcher;
        }

        public AuthFilterBuilder setRequestMatcher(RequestMatcher requestMatcher) {
            this.requestMatcher = requestMatcher;

            return this;
        }

        public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
            return authenticationSuccessHandler;
        }

        public AuthFilterBuilder setAuthenticationSuccessHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
            this.authenticationSuccessHandler = authenticationSuccessHandler;

            return this;
        }

        public AuthenticationFailureHandler getAuthenticationFailureHandler() {
            return authenticationFailureHandler;
        }

        public AuthFilterBuilder setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
            this.authenticationFailureHandler = authenticationFailureHandler;

            return this;
        }

        public boolean isContinueChainBeforeSuccessfulAuthentication() {
            return continueChainBeforeSuccessfulAuthentication;
        }

        public AuthFilterBuilder setContinueChainBeforeSuccessfulAuthentication(boolean continueChainBeforeSuccessfulAuthentication) {
            this.continueChainBeforeSuccessfulAuthentication = continueChainBeforeSuccessfulAuthentication;

            return this;
        }

        public AuthFilter build() {
            return new AuthFilter(this);
        }
    }
}
