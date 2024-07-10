package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional // rollback 되므로 dbeaver 에는 남지 않음
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex04 {

    @Autowired
    private JoinService service;

    @Test
    void test1() {
        RequestJoin form = new RequestJoin();
        form.setEmail("user100@test.org"); // 이메일
        form.setPassword("12345678"); // 비밀번호
        form.setConfirmPassword(form.getPassword()); // 비밀번호 확인 = 비밀번호 와 동일
        form.setUserName("사용자100"); // 회원명
        form.setAgree(true); // 약관 동의 여부

        service.process(form); // 위의 필수 항목 목록 전부 확인
    }
}