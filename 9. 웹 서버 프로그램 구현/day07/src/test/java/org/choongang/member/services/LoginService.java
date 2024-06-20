package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.Validator;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {

    private Validator<HttpServletRequest> validator; // 의존 역전 원칙 | 선언만 했을 뿐 객체는 아님
    private MemberMapper mapper; // 선언만 했을 뿐 객체는 아님

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper) { // () = 생성자 매개변수
        this.validator = validator; // 개방 폐쇄 원칙 | 객체로 만듦
        this.mapper = mapper; // 개방 폐쇄 원칙 | 객체로 만듦
    }

    public void process(HttpServletRequest request) {
        // 로그인 유효성 검사
        validator.check(request);
    }
}
