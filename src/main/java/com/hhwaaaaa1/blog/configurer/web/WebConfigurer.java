package com.hhwaaaaa1.blog.configurer.web;

import com.hhwaaaaa1.blog.configurer.security.enumeration.URL;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(URL.ROOT.value()).setViewName("forward:/dist/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
