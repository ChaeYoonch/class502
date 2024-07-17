package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang")
@Import({DBConfig.class,
        MessageConfig.class,
        InterceptorConfig.class,
        FileConfig.class}) // MvcConfig 에 DBConfig, MessageConfig 연동
//@RequiredArgsConstructor // 의존성 추가
public class MvcConfig implements WebMvcConfigurer { // WebMvcConfigurer -> 설정 틀 제공함 | 인터페이스 임!!

    //private final JoinValidator joinValidator;

    // 모든 컨트롤러에 적용될 수 있는 전역 Validator
    /*@Override
    public Validator getValidator() {
        return joinValidator; // 전역 벨리데이터
    }*/

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

        registry.addViewController("/mypage")
                .setViewName("mypage/index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp"); // templates 를 jsp 로 쓸 때만 .jsp 로 사용
    } // 기본 설정 2

    @Bean // PropertySources : 프로퍼티 파일 설정 내용 / PlaceholderConfigurer : 설정 방식
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(new ClassPathResource("application.properties")); // classpath : resources 임!

        return conf;
    }
}