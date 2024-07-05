package exam01;

import exam01.config.AppCtx;
import exam01.config.AppCtx2;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.services.InfoService;
import exam01.member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);
        // InfoService 만들기 전 -> MemberDao memberDao = ctx.getBean(MemberDao.class);

        RequestJoin form = RequestJoin.builder()
                            .email("user01@test.org")
                            .password("12345678")
                            .ConfirmPassword("12345678")
                            .userName("사용자01")
                            .build();
        joinService.process(form);

        infoService.printList();
        // InfoService 만들기 전 -> memberDao.getList().forEach(System.out::println);

        ctx.close(); // 객체 조립기로 완성된 객체
    }

    @Test
    void test2() {
        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class, AppCtx2.class); (1)

        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("exam01.config"); (2)

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean(JoinService.class); // AppCtx2 | AppCtx 에 @Import 추가 후에는 (1, 2) 외에도 가능
        InfoService infoService = ctx.getBean(InfoService.class); // AppCtx2 | AppCtx 에 @Import 추가 후에는 (1, 2) 외에도 가능

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .password("12345678")
                .ConfirmPassword("12345678")
                .userName("사용자01")
                .build();
        joinService.process(form);

        infoService.printList();

        Greeter g1 = ctx.getBean(Greeter.class); // AppCtx
        g1.hello("이이름");

        ctx.close();
    }
}