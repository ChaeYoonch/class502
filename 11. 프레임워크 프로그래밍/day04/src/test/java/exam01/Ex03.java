package exam01;

import config.AppCtx;
import mappers.member.MemberMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex03 {

    @Autowired
    private MemberMapper memeberMapper;

    @Test
    void test1() {
        System.out.println(memeberMapper);
    }
}