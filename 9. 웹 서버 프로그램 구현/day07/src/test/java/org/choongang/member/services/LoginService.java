package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
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

        // 로그인 처리 - 회원 정보 조회, 세션에 유지
        String email = request.getParameter("email"); //  validator.check(request); 로 이메일이 있음을 알 수 있음
        Member member = mapper.get(email);

        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    } // 세션 객체는 HttpServletRequest request 여기서 조회 가능 - request 객체 가져올 수 있음
}