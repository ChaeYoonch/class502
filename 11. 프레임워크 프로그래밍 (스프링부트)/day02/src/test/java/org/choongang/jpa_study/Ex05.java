package org.choongang.jpa_study;

import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
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

    }
}