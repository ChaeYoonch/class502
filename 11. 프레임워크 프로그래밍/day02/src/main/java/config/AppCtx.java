package config;

import global.annotations.ManualBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정 클래스 임을 알려 주는 애노테이션
@ComponentScan(basePackages="member",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = ManualBean.class)) // () 안이 스캔 범위
public class AppCtx {

}