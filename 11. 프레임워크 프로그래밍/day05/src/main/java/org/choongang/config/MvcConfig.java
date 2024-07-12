package org.choongang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang")
@Import(DBConfig.class)
public class MvcConfig implements WebMvcConfigurer { // WebMvcConfigurer -> 설정 틀 제공함 | 인터페이스 임!!

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    } // 기본 설정 1

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/"); // 특정 경로 입력 시 해당 경로로 매칭 | ** : 현재 경로 포함 하위 경로 | /** : 모든 경로
    } // 정적 경로 관련 추가 | 첫 번째는 Controller 빈 두 번째는 정적 경로

    @Override
    public void addViewControllers(ViewControllerRegistry registry) { // registry 로 index.jsp 연동
        registry.addViewController("/") // 메인 경로
                .setViewName("main/index"); // 컨트롤러 연동하지 않고 뷰 바로 연결
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp"); // templates 를 jsp 로 쓸 때만 .jsp 로 사용
    } // 기본 설정 2
}