package exam01;

import config.AppCtx;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1() { // AnnotationConfig (= 설정 방식 : 애노테이션 사용) | ApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean(JoinService.class);

        ctx.close();
    }
}