package member.services;

import lombok.RequiredArgsConstructor;
import member.controllers.RequestJoin;
import member.validators.JoinValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 쓸 때 사용
public class JoinService { // 회원가입 서비스

    private final JoinValidator validator;

    public void process(RequestJoin form) {
        // 유효성 검사
        validator.check(form);

        // 비밀번호 해시화

        // DB 저장
    }
}