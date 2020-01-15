package com.hhwaaaaa1.blog.configurer.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WebSecurityConfigurerTest {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void bCryptPasswordEncoderTest(){
        System.out.println(this.bCryptPasswordEncoder.matches("1111", "$2a$10$MONmH6.5X1227vzuI5/i.OvfcCfTeqEiklYtiDfwCvwPWALmimdbi"));
    }
}