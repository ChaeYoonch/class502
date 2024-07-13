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

}