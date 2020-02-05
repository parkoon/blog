package com.hhwaaaaa1.blog.configurer.security.filter;

import com.hhwaaaaa1.blog.configurer.security.model.LoginModel;
import com.hhwaaaaa1.blog.configurer.security.token.PreLoginToken;
import com.hhwaaaaa1.blog.support.utility.CommonUtility;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    public static LoginFilter.LoginFilterBuilder builder(AuthenticationManager authenticationManager) {
        return new LoginFilter.LoginFilterBuilder(authenticationManager);
    }


    private LoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    protected LoginFilter(LoginFilter.LoginFilterBuilder loginFilterBuilder) {
        super(loginFilterBuilder.defaultFilterProcessesUrl);
        super.setAuthenticationManager(loginFilterBuilder.authenticationManager);

        this.setAuthenticationSuccessHandler(loginFilterBuilder.authenticationSuccessHandler);
        this.setAuthenticationFailureHandler(loginFilterBuilder.authenticationFailureHandler);
    }


    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Override
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        LoginModel loginModel = CommonUtility.objectMapper.readValue(httpServletRequest.getReader(), LoginModel.class);

        return super.getAuthenticationManager().authenticate(new PreLoginToken(loginModel.getUserId(), loginModel.getUserPassword()));
    }


    public static class LoginFilterBuilder {
        private String defaultFilterProcessesUrl;

        private AuthenticationManager authenticationManager;

        private AuthenticationSuccessHandler authenticationSuccessHandler;
        private AuthenticationFailureHandler authenticationFailureHandler;


        private LoginFilterBuilder() {
        }

        private LoginFilterBuilder(AuthenticationManager authenticationManager) {
            this.authenticationManager = authenticationManager;
        }


        public LoginFilterBuilder setDefaultFilterProcessesUrl(String defaultFilterProcessesUrl) {
            this.defaultFilterProcessesUrl = defaultFilterProcessesUrl;

            return this;
        }

        public LoginFilterBuilder setAuthenticationSuccessHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
            this.authenticationSuccessHandler = authenticationSuccessHandler;

            return this;
        }

        public LoginFilterBuilder setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
            this.authenticationFailureHandler = authenticationFailureHandler;

            return this;
        }

        public LoginFilter build() {
            return new LoginFilter(this);
        }
    }
}
