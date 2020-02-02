package com.hhwaaaaa1.blog.configurer.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JwtFactory {
    private static final Logger logger = LoggerFactory.getLogger(JwtFactory.class);


    public String generating(Authentication authentication){
        String jwtToken = null;

        try {
            /*
                iss: token을 발급한 발급자(issuer)
                sub: claim의 주제(subject)로 토큰이 갖는 문맥을 의미.
                aud: 토큰을 수신할 수신자(audience)
                exp: 만료시간
                nbf: not before의 의미로, 이 시간 이전에는 토큰을 처리하지 않아야  한다.
                iat: 토큰이 발급된 시간(issued at)
                jti: jwt id로 토큰에 대한 식별자
             */
            jwtToken = JWT.create()
                    .withIssuer((String)authentication.getPrincipal())
                    .withClaim("uid", (String)authentication.getPrincipal())        //user id
                    .withClaim( "rol", authentication.getAuthorities().toString() ) //user role
                    .withClaim( "exp",  Date.from(LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault()).toInstant())) //expire time
                    .sign( generatesAlgorithm(authentication) );
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }

        return jwtToken;
    }

    private Algorithm generatesAlgorithm(Authentication authentication) throws UnsupportedEncodingException {
        return Algorithm.HMAC256(com.hhwaaaaa1.blog.enums.JWT.PRIVATE_KEY.value());
    }
}