package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05 { // 스프링 구현 객체로 다 만들어져 있음

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                              .email("user01@test.org")
                              .password("12345678")
                              .userName("사용자01")
                              .authority(Authority.USER)
                              .build();

        memberRepository.saveAndFlush(member); // 2개 1번에 작성

        /* memberRepository.save(member);
        memberRepository.flush(); // DB 에 영구 반영 */
    }

    @Test
    void test1() {
        Member member = memberRepository.findById();
    }
}