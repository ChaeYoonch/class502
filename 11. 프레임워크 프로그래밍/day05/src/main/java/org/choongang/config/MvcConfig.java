package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang") // 자동 스캔 대상임!!
/*@Import({DBConfig.class,
        MessageConfig.class,
        InterceptorConfig.class,
        FileConfig.class})*/ // MvcConfig 에 DBConfig, MessageConfig 연동 | 스캔 범위 아닐 때, @Bean 이 만들어지지 않을 때, @Component 자동 생성 못할 때 추가
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

    @Bean // PropertySources : 프로퍼티 파일 설정 내용 | PlaceholderConfigurer : 설정 방식
    // 설정 파일은 한 번 정의하면 바꾸지 않기 때문에 static 으로 정의함
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        String fileName = "application";
        String profile = System.getenv("spring.profiles.active");
        fileName += StringUtils.hasText(profile) ? "-" + profile : ""; // 없을 때는 빈 값

        /**
         * 환경 변수에 따라 달리 구분 예시
         * spring.profiles.active = dev -> application-dev
         * spring.profiles.active = prod -> application-prod
         */

        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(new ClassPathResource(fileName + ".properties")); // classpath : resources 임! | application.properties -> 기본 설정 | fileName + ".properties" -> 환경 변수에 따라 달리 구분

        return conf;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                                    .json()
                                    .serializerByType(LocalDate.class, new LocalDateSerializer(formatter))
                                    .build();
        // objectMapper 에 담은 builder 값                                요기에서 가져옴
        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }
}