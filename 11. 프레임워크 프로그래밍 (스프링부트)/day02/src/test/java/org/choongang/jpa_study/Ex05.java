package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05 { // 스프링 구현 객체로 다 만들어져 있음

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {

        List<Member> members = IntStream.rangeClosed(1, 10) // 1 ~ 10
                                        .mapToObj(i -> Member.builder()
                                                              .email("user" + i + "@test.org")
                                                              .password("12345678")
                                                              .userName("사용자" + i)
                                                              .authority(Authority.USER)
                                                              .build()) .toList(); // 목록 형태 -> Collection 형태

        memberRepository.saveAllAndFlush(members);
        /*
        for (int i = 1; i <= 10; i++) {
            Member member = Member.builder()
                    .email("user" + i + "@test.org")
                    .password("12345678")
                    .userName("사용자" + i)
                    .authority(Authority.USER)
                    .build();

            memberRepository.save(member); // save 하면 영속성 안에 있음
        }
        */
        memberRepository.flush();
        // memberRepository.saveAndFlush(member); // 2개 1번에 작성
        // member.setUserName("(수정)사용자01"); // flush() 작성하지 않아도 암묵적으로 flush가 됨

        // memberRepository.save(member);
        // memberRepository.flush(); // DB 에 영구 반영
    }

    @Test
    void test1() {
        Member member = memberRepository.findById(1L).orElse(null); // 조회 메서드 -> 기본키로 조회
        System.out.println(member);

        member.setUserName("(수정)사용자01");

        Member member2 = memberRepository.findById(1L).orElse(null); // 조회 메서드 -> 기본키로 조회
        System.out.println(member2);
    }

    @Test
    void test2() {

    }
}