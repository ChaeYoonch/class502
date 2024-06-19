package org.choongang.member.services;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;

// 회원 가입 기능
public class JoinService {
    public void process(RequestJoin form) { // 실패 시 BadRequestException 의 경우 나타날 메세지 설정
        String email = form.getEmail();
        if (email == null || email.isBlank()) {
            throw new BadRequestException("이메일을 입력하세요.");
        }
    }
}
