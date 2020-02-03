package com.hhwaaaaa1.blog.configurer.security.userDetailsService;

import com.hhwaaaaa1.blog.api.entity.mem.User;
import com.hhwaaaaa1.blog.api.repository.mem.UserRepository;
import com.hhwaaaaa1.blog.configurer.security.userDetails.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;


public class LoginUserDetailsService implements UserDetailsService {
    public LoginUserDetailsService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(s);


        return new LoginUser(
                user.getUserId(),
                user.getUserPwd(),
                user.getUserRoles()
                        .stream()
                        .map(
                                role -> new SimpleGrantedAuthority(role.getRole().getRoleCd())
                        )
                        .collect(
                                Collectors.toList()
                        )
        );
    }
}
