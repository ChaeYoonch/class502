package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 컨테이너가 설정 클래스로 인식하기 위해 필요함
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer { // 설정 클래스 | MVC 관련 모든 설정이 담겨 있음 = WebMvcConfigurer
    // 환경에 따라 바뀔 수 있는 것은 직접 설정해야 함
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) { // configureViewResolvers 기본 셋팅 = WEB-INF 의 templates
        registry.jsp("/WEB-INF/templates/", ".jsp"); // 반환값이 "/WEB-INF/templates/", ".jsp" 사이에 추가됨
    }
}