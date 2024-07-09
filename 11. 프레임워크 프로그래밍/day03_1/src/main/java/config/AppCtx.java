package config;

import exam01.Calculator;
import exam01.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx { // Spring 관리 객체의 설정 파일이닷!

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}