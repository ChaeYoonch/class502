package config;

import exam01.Calculator;
import exam01.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // AOP 자동 설정 애노테이션
public class AppCtx { // Spring 관리 객체의 설정 파일이닷!

    @Bean
    public ProxyCalculator2 proxyCalculator2() {
        return new ProxyCalculator2();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}