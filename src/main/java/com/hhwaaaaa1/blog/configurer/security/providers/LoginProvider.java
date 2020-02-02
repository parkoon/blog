package com.hhwaaaaa1.blog.configurer.security.providers;

import com.hhwaaaaa1.blog.configurer.security.userDetails.LoginUser;
import com.hhwaaaaa1.blog.configurer.security.tokens.PostLoginToken;
import com.hhwaaaaa1.blog.configurer.security.tokens.PreLoginToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

public class LoginProvider extends DaoAuthenticationProvider {
    public static LoginProvider.LoginProviderBuilder builder() {
        return new LoginProvider.LoginProviderBuilder();
    }

    private LoginProvider() {
    }

    private LoginProvider(LoginProvider.LoginProviderBuilder loginProviderBuilder) {
        super.setUserDetailsService(loginProviderBuilder.userDetailsService);
        super.setPasswordEncoder(loginProviderBuilder.bCryptPasswordEncoder);
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            super.authenticate(authentication);

            return new PostLoginToken(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities());
        } catch (UsernameNotFoundException notFound) {
            logger.error("Got UsernameNotFoundException and change to return null");
            return null;
        }
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        LoginUser loginUserDetails = (LoginUser) userDetails;
        if (!(super.getPasswordEncoder().matches((String) authentication.getCredentials(), loginUserDetails.getUserPassword())))
            throw new NoSuchElementException("사용자 정보가 올바르지 않습니다.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreLoginToken.class.isAssignableFrom(aClass);
    }


    public static class LoginProviderBuilder {
        private LoginProviderBuilder() {
        }


        private UserDetailsService userDetailsService;
        private BCryptPasswordEncoder bCryptPasswordEncoder;


        public LoginProviderBuilder setLoginUserDetailsService(UserDetailsService userDetailsService){
            this.userDetailsService = userDetailsService;

            return this;
        }

        public LoginProviderBuilder setEncoder(BCryptPasswordEncoder bCryptPasswordEncoder){
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;

            return this;
        }


        public LoginProvider build() throws Exception {
            return new LoginProvider(this);
        }
    }
}
