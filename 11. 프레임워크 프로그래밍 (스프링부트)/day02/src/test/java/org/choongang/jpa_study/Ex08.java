package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // 테스트별로 위에 @Test 붙이지 않아도 됨
@Transactional
public class Ex08 {
    @PersistenceContext // 의존성 주입
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        em.setFlushMode(FlushModeType.AUTO); // 바뀐 값으로 유지됨

        Member member = Member.builder()
                              .email("user01@test.org")
                              .password("12345678")
                              .userName("사용자01")
                              .authority(Authority.USER)
                              .build(); // 자동 추가되므로 날짜 & seq 시퀀스 번호 생성 X
        memberRepository.saveAllAndFlush(member);

        em.clear();
    }

    @Test
    void test1() {
        Member member = memberRepository.findById(1L).orElse(null);
    }
}