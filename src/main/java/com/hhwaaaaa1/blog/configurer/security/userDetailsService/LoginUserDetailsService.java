package com.hhwaaaaa1.blog.configurer.security.userDetailsService;

import com.hhwaaaaa1.blog.enums.UserRole;
import com.hhwaaaaa1.blog.configurer.security.userDetails.LoginUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LoginUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new LoginUser("zlagusdbs", "$2a$10$MONmH6.5X1227vzuI5/i.OvfcCfTeqEiklYtiDfwCvwPWALmimdbi", Arrays.asList(UserRole.values()).stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList()));
    }
}
