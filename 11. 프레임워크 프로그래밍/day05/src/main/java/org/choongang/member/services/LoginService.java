package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService { // 로그인 서비스

    private final MemberMapper mapper;

    public void process(String form) {
        /**
         * 1. email 로 회원 조회
         * 2. 세션에 회원 정보를 유지
         */
    }
}