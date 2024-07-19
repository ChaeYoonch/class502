package org.choongang.config;

import lombok.RequiredArgsConstructor;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@RequiredArgsConstructor
public class ThymeleafConfig implements WebMvcConfigurer { // Thymeleaf : 번역 과정 <= 서버가 일을 함 = 자원 소비 O
    private final WebApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver templateResolver() { // TemplateResolver : template 경로에 대한 설정 | Natural Template 지향 -> 관례적으로 확장자 html | setPrefix & setSuffix 사이에 주소 O
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates2/"); // prefix | 템플릿 경로 설정
        templateResolver.setSuffix(".html"); // surffix
        templateResolver.setCacheable(false); // 캐시 설정 | 설정 파일에서 하고 코드에서 따로 설정하지 X
        return templateResolver; // 위의 것 가져옴
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); // EL 해석 / EL 식 속성 사용 가능하게 해줌
        templateEngine.addDialect(new Java8TimeDialect()); // Dialect - 확장 기능 | Temporals 추가됨
        templateEngine.addDialect(new LayoutDialect()); // Dialect - 확장 기능 | Layout 속성 사용 가능해짐
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html"); // 미리 설정해야 되는 부분 -> 매번 설정할 필요 없음!! <%@ page contentType="text/html; charset=UTF-8" %> 이렇게 안 적어도 됨!!
        resolver.setCharacterEncoding("utf-8"); // 미리 설정해야 되는 부분 -> 매번 설정할 필요 없음!!
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver()); // 설정을 반영 시킴
    }
}