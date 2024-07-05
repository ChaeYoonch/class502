package exam01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = "exam01.member") // member 패키지 포함 하위 패키지가 범위가 됨
@ComponentScan("exam01.member")
public class AppCtx3 {

}