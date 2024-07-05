package exam01;

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
}