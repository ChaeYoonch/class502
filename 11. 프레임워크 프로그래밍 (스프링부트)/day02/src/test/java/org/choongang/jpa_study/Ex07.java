package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
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

        memberRepository.saveAllAndFlush(members); // (1)
    }

    @Test
    void test1() {
        QMember member = QMember.member; // QMember 객체 가져옴 | member -> entity 에 정의된 항목 가져올 수 있음
        BooleanExpression c1 = member.userName.contains("용"); // (2)

        List<Member> members = (List<Member>) memberRepository.findAll(c1); // (1) 의 memberRepository 가져옴 | () 안에 (2) 의 c1 연결
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        String key = "용"; // (3)
        QMember member = QMember.member;
        BooleanBuilder andBuilder = new BooleanBuilder();

        BooleanBuilder orBuilder = new BooleanBuilder(); // 이메일 & 사용자명 or 로 연결
        orBuilder.or(member.email.contains(key))
                 .or(member.userName.contains(key)); // (3) 의 key 연결

        andBuilder.and(orBuilder);

        List<Member> members = (List<Member>) memberRepository.findAll(andBuilder); // (List<Member>) 로 형변환 하지 않으면 붉은 줄 생김
        members.forEach(System.out::println);
    }

    @Test
    void test3() {
        QMember member = QMember.member;
        BooleanExpression c1 = member.email.concat(member.userName).contains("용");

        List<Member> members = (List<Member>) memberRepository.findAll(c1); // (List<Member>) 로 형변환 하지 않으면 붉은 줄 생김
    }
}