package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.mapper.MemberMapper;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator { // 로그인 서비스 구성

    private MemberMapper mapper; // 의존성 추가 | 선언만 했을 뿐 객체는 아님

    public LoginValidator(MemberMapper mapper) {
        this.mapper = mapper; // 개방 폐쇄 원칙 | 객체로 만듦
    }

    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        // 필수 항목 검증
        checkRequired(email, new BadRequestException("이메일을 입력하세요."));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요."));

        // 이메일로 회원이 조회되는지 검증
    }
}