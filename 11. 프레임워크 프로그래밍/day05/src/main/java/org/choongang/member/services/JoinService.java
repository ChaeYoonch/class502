package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 쓸 때 사용
public class JoinService { // 회원가입 서비스

    // 의존성 추가 부분
    private final JoinValidator validator;
    private final MemberMapper mapper;

    public void process(RequestJoin form) {
        // 유효성 검사
        validator.check(form);

        // 비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        // DB 저장
        Member member = Member.builder()
                            .email(form.getEmail())
                            .password(hash)
                            .userName(form.getUserName())
                            .build();

        int result = mapper.register(member);
        if (result < 1) {
            throw new BadRequestException("회원가입 실패");
        }
    }
}