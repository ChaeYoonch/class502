package org.choongang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer { // file 관련 | 정적 경로 설정 | WebMvcConfigurer : 설정 틀 , 인터페이스
    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 파일 업로드 정적 경로 설정
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///" + uploadPath); // 파일 경로 입력 시에는 /가 1개 제거되므로 3개 쓴 것!
    }
}