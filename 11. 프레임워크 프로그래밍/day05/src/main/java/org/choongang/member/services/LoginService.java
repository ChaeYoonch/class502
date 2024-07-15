package org.choongang.member.services;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService { // 로그인 서비스

    private final MemberMapper mapper;
    private final HttpSession session; // 세션 가져옴 | 개인 서비스 기술 - 데이터는 서버에 있음

    public void process(String email) {
        /**
         * 1. email 로 회원 조회
         * 2. 세션에 회원 정보를 유지
         */

        /* 1. email 로 회원 조회 */
        Member member = mapper.get(email);
        if (email == null) {
            return;
        }

        session.setAttribute("member", member);
    }

    public void process(RequestLogin form) {

    }
}