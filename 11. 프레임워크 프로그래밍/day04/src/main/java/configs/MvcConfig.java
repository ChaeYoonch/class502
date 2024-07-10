package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 컨테이너가 설정 클래스로 인식하기 위해 필요함
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer { // 설정 클래스 | MVC 관련 모든 설정이 담겨 있음 = WebMvcConfigurer

}