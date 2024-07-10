package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 컨테이너가 설정 클래스로 인식하기 위해 필요함
@ComponentScan({"member.controllers"})
public class ControllerConfig {

}