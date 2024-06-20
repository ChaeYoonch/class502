package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
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
        String message = "아이디 또는 비밀번호가 일치하지 않습니다.";
        Member member = mapper.get(email);
        checkTrue(member != null, new BadRequestException(message));
    } // 이메일 또는 비밀번호 각각이 틀렸다고 문구가 뜨면 해커에게 유리하므로 두루뭉술하게 문구 작성 => 예측 불가능성
}