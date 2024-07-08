package exam01;

import board.services.BoardService2;
import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class); // (1)

        /* BoardService service = ctx.getBean(BoardService.class); // (2)
        service.write(); // 담겨 있는 객체 에서 꺼내 와서 사용 (3) */

        BoardService2 s1 = ctx.getBean(BoardService2.class);
        BoardService2 s2 = ctx.getBean(BoardService2.class);
        System.out.println(s1 == s2); // false -> 싱글톤 패턴이 아니므로!!

        ctx.close();
    }
}