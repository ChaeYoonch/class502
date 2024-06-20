package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.Validator;

public class LoginService {

    private Validator<HttpServletRequest> validator; // 의존 역전 원칙 | 선언만 했을 뿐 객체는 아님

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator; // 개방 폐쇄 원칙 | 객체로 만듬
    }

    public void process(HttpServletRequest request) {
        // 로그인 유효성 검사
        validator.check(request);
    }
}
