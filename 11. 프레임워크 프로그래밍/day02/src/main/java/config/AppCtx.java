package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스 임을 알려 주는 애노테이션
@ComponentScan("member") // () 안이 스캔 범위
public class AppCtx {

}