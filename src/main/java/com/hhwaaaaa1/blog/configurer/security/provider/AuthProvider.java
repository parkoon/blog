package com.hhwaaaaa1.blog.configurer.security.provider;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.hhwaaaaa1.blog.configurer.security.token.PostAuthToken;
import com.hhwaaaaa1.blog.configurer.security.token.PreAuthToken;
import com.hhwaaaaa1.blog.configurer.security.utility.JwtDecoder;
import com.hhwaaaaa1.blog.utility.CommonUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthProvider extends DaoAuthenticationProvider {
    public static final Logger logger = LoggerFactory.getLogger(AuthProvider.class);


    public static AuthProvider.AuthProviderBuilder builder(JwtDecoder jwtDecoder) {
        return new AuthProvider.AuthProviderBuilder(jwtDecoder);
    }

    public static List<SimpleGrantedAuthority> parseAuthorities(String userRole) {
        List<Map<String, String>> roles = null;

        try {
            roles = CommonUtility.objectMapper.readValue(userRole, new TypeReference<List<Map<String, String>>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roles.stream().map(
                r -> new SimpleGrantedAuthority(r.get("authority"))
        ).collect(Collectors.toList());
    }


    private JwtDecoder jwtDecoder;


    private AuthProvider(AuthProvider.AuthProviderBuilder authProviderBuilder) {
        this.jwtDecoder = authProviderBuilder.jwtDecoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        DecodedJWT decodedJWT = jwtDecoder.decodeJwt(((PreAuthToken) authentication).getToken());
        String uid = decodedJWT.getClaim("uid").asString();
        String rol = decodedJWT.getClaim("rol").asString();

        //TODO: token 재검증 -> signature 재생성 후 비교, expire time 검증
        //TODO: Exception 발생 시, 로그인 페이지로 redirect

        return new PostAuthToken(uid, null, AuthProvider.parseAuthorities(rol));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthToken.class.isAssignableFrom(aClass);
    }


    public static class AuthProviderBuilder {
        private JwtDecoder jwtDecoder;


        private AuthProviderBuilder(JwtDecoder jwtDecoder) {
            this.jwtDecoder = jwtDecoder;
        }


        public AuthProvider build() throws Exception {
            return new AuthProvider(this);
        }
    }
}
