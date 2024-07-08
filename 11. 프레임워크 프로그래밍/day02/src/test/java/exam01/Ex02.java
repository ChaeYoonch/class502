package exam01;

import board.services.BoardService;
import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class); // (1)

        BoardService service = ctx.getBean(BoardService.class); // (2)
        service.write(); // 담겨 있는 객체에서 꺼내와서 사용 (3)

        ctx.close();
    }
}