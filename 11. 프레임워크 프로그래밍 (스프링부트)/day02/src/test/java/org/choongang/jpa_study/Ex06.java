package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex06 {

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
                        .build()).toList(); // 목록 형태 -> Collection 형태

        memberRepository.saveAllAndFlush(members);
    }

    @Test
    void test1() {
        Member member = memberRepository.findByEmail("user02@test.org");
        System.out.println(member);
    }

    @Test
    void test2() {
        List<Member> members = memberRepository.findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc("ser", "용");
        members.forEach(System.out::println);
    }

    @Test
    void test3() {
        Pageable pageable = PageRequest.of(1, 3); // (0, 3) 0페이지 부터 3개씩 나옴
        Page<Member> data = memberRepository.findByEmailContaining("ser", pageable); // Page -> 조회한 데이터를 가져올 수 있는 메서드

        List<Member> items = data.getContent(); // (1) 위의 data 가져옴 | 조회된 데이터
        long total = data.getTotalElements();
        System.out.printf("총 개수 : %d%n", total); // 위의 total 가져옴
        items.forEach(System.out::println); // (1) 의 items 가져옴
    }

    @Test
    void test4() {
        List<Member> members = memberRepository.getMembers("%ser", "%용%");
        members.forEach(System.out::println);
    }
}