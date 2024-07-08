package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.InfoService;
import member.services.JoinService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    private static final Log log = LogFactory.getLog(Ex01.class);

    @Test
    void test1() { // AnnotationConfig (= 설정 방식 : 애노테이션 사용) | ApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);

        RequestJoin form = RequestJoin.builder()
                            .email("user01@test.org")
                            .password("12345678")
                            .ConfirmPassword("12345678")
                            .userName("사용자01")
                            .build();

        joinService.process(form); // 가입한 회원 정보를 담고 있음
        infoService.printList();

        ctx.close();
    }
}