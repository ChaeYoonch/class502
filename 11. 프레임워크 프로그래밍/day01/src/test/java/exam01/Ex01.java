package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1() { // 설정 방식이 AnnotationConfig 인 스프링 컨테이너
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class); // (매개변수) = 클래스 클래스 | 스프링 컨테이너 객체

        Greeter g1 = ctx.getBean("greeter", Greeter.class); // "메서드명", 클래스 클래스 가 매개변수로 들어감 | get.Bean = 꺼내오는 역할
        g1.hello("이이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        g2.hello("김이름");

        System.out.println(g1 == g2); // 주소 비교 -> 둘이 같다고 나옴 = 싱글톤 형태로 관리

        ctx.close();
    }
}