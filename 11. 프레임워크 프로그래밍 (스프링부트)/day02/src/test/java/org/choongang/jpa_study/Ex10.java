package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.MemberProfile;
import org.choongang.member.repositories.MemberProfileRepository;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class Ex10 {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberProfileRepository profileRepository;

    @PersistenceContext // 영속성
    private EntityManager em;

    @BeforeEach
    void init() {
        MemberProfile profile = MemberProfile.builder()
                                             .profileImages("이미지")
                                             .status("상태")
                                             .build();
        profileRepository.saveAllAndFlush(profile);

        Member member = Member.builder()
                              .email("user01@test.org")
                              .password("12345678")
                              .userName("사용자01")
                              .authority(Authority.USER) // 짝수 = USER, 홀수 = ADMIN 나오게 할거임
                              .profile(profile)
                              .build(); // 자동 추가되므로 날짜 & seq 시퀀스 번호 생성 X

        memberRepository.saveAndFlush(member);

        em.clear();
    }

    @Test
    void test1() {
        Member member = memberRepository.findById(1L).orElse(null);
    }
}