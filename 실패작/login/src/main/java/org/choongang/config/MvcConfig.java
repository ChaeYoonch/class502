package org.choongang.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang")
@Import(DBConfig.class) // MvcConfig 에 DBConfig 연동
public class MvcConfig implements WebMvcConfigurer { // WebMvcConfigurer -> 설정 틀 제공

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    } // 기본 설정 1

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp"); // templates 를 jsp 로 쓸 때만 .jsp 로 사용
    } // 기본 설정 2
}