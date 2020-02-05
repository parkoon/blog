package com.hhwaaaaa1.blog.configurer.security.handler;

import com.hhwaaaaa1.blog.configurer.security.constraint.SecurityConstraint;
import com.hhwaaaaa1.blog.configurer.security.token.PostLoginToken;
import com.hhwaaaaa1.blog.configurer.security.utility.JwtFactory;
import com.hhwaaaaa1.blog.support.utility.CommonUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(LoginAuthenticationSuccessHandler.class);


    public LoginAuthenticationSuccessHandler(){
    }

    public LoginAuthenticationSuccessHandler(JwtFactory jwtFactory){
        this.jwtFactory = jwtFactory;
    }


    private JwtFactory jwtFactory;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        PostLoginToken preLoginToken = (PostLoginToken)authentication;

        String jwtToken = jwtFactory.generating(preLoginToken);

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.getWriter().write(CommonUtility.objectMapper.writeValueAsString(SecurityConstraint.TOKEN_NAME+":"+jwtToken));

        //TODO: redirect as origin url -> need a finding a origin url
    }
}
