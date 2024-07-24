package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
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
public class Ex07 {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {

        List<Member> members = IntStream.rangeClosed(1, 10) // 1 ~ 10
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)
                        .authority(i % 2 == 0 ? Authority.USER : Authority.ADMIN)
                        .build()).toList(); // 목록 형태 -> Collection 형태

        memberRepository.saveAllAndFlush(members);
    }

    @Test
    void test1() {
        QMember member = QMember.member; // QMember 객체 가져옴 | member -> entity 에 정의된 항목 가져올 수 있음
    }
}