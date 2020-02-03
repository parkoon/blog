package com.hhwaaaaa1.blog.configurer.security;

import com.hhwaaaaa1.blog.api.repository.mem.UserRepository;
import com.hhwaaaaa1.blog.configurer.security.enumeration.URL;
import com.hhwaaaaa1.blog.configurer.security.filter.AuthFilter;
import com.hhwaaaaa1.blog.configurer.security.filter.LoginFilter;
import com.hhwaaaaa1.blog.configurer.security.handler.AuthAuthenticationFailurehandler;
import com.hhwaaaaa1.blog.configurer.security.handler.AuthAuthenticationSuccessHandler;
import com.hhwaaaaa1.blog.configurer.security.handler.LoginAuthenticationFailureHandler;
import com.hhwaaaaa1.blog.configurer.security.handler.LoginAuthenticationSuccessHandler;
import com.hhwaaaaa1.blog.configurer.security.provider.AuthProvider;
import com.hhwaaaaa1.blog.configurer.security.provider.LoginProvider;
import com.hhwaaaaa1.blog.configurer.security.userDetailsService.LoginUserDetailsService;
import com.hhwaaaaa1.blog.configurer.security.utility.AuthRequestMatcher;
import com.hhwaaaaa1.blog.configurer.security.utility.JwtDecoder;
import com.hhwaaaaa1.blog.configurer.security.utility.JwtFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepository;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //@formatter:off
        auth
            .authenticationProvider(
                LoginProvider.builder()
                    .setLoginUserDetailsService(new LoginUserDetailsService(userRepository))
                    .setEncoder(new BCryptPasswordEncoder())
                    .build()
            )
            .authenticationProvider(
                AuthProvider.builder(new JwtDecoder())
                    .build()
            );
        //@formatter:on
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
                .antMatchers(URL.H2_URL.value(), URL.H2_URL.value()+"/**")
                    .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers(URL.DEFAULT_LOGIN_FORM_PATH.value())
                    .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers(URL.ROOT.value())
                    .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/api/**")
                    .authenticated()
                .and()
            .authorizeRequests()
                .anyRequest()
                    .permitAll()
                .and()
            .headers()
                .frameOptions()
                    .sameOrigin()
                .and()
            .formLogin()
                .loginPage(URL.DEFAULT_LOGIN_FORM_PATH.value())
                .usernameParameter("userId")
                .passwordParameter("userPassword")
                .loginProcessingUrl(URL.DEFAULT_FILTER_PROCESSES_URL.value())
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .addFilterBefore(
                LoginFilter.builder(super.authenticationManagerBean())
                    .setDefaultFilterProcessesUrl(URL.DEFAULT_FILTER_PROCESSES_URL.value())
                    .setAuthenticationSuccessHandler(new LoginAuthenticationSuccessHandler(new JwtFactory()))   //need a jwtFactory
                    .setAuthenticationFailureHandler(new LoginAuthenticationFailureHandler())
                    .build()
                ,UsernamePasswordAuthenticationFilter.class
            )
            .addFilterBefore(
                AuthFilter.builder(super.authenticationManagerBean())
                    .setRequestMatcher(
                            new AuthRequestMatcher(
                                    Arrays.asList(
                                            "/api/**"
                                    ),
                                    Arrays.asList(
                                            URL.DEFAULT_FILTER_PROCESSES_URL.value()
                                    )
                            )
                    )
                    .setAuthenticationSuccessHandler(new AuthAuthenticationSuccessHandler())
                    .setAuthenticationFailureHandler(new AuthAuthenticationFailurehandler())
//                    .setContinueChainBeforeSuccessfulAuthentication(true)
                    .build()
                ,UsernamePasswordAuthenticationFilter.class
            )
            .csrf()
                .disable();
        // @formatter:on
    }
}
