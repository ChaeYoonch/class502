package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 설정 클래스 - 스프링 컨테이너가 관리할 객체를 정의, 설정
// @Import(value={AppCtx2.class}) // AppCtx 에 AppCtx2 추가함
// @Import({AppCtx2.class}) // 값이 한개일 경우 value= 제거 가능
@Import(AppCtx2.class) // { 중괄호 } 도 제거 가능
@Configuration // 알려주는 역할
public class AppCtx {

    @Bean // '얘가 스프링이 관리할 객체'라고 알려주는 역할
    public Greeter greeter() {
        return new Greeter();
    }
}