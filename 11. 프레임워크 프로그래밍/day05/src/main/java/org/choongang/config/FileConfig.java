package org.choongang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer { // file 관련 | 정적 경로 설정 | WebMvcConfigurer : 설정 틀 , 인터페이스

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 파일 업로드 정적 경로 설정
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}