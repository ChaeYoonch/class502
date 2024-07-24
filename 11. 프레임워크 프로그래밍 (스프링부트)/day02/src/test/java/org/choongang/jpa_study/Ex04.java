package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex04 {

    @PersistenceContext // 의존성 주입
    private EntityManager em;

    @Test
    void test1() throws Exception {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");

        em.persist(member); // 영속성 안에 집어 넣음
        em.flush();

        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createdAt : %s, modifiedAt : %s", member.getCreatedAt(), member.getModifiedAt());

        Thread.sleep(5000);
        member.setUserName("(수정)사용자01");
        member.setCreatedAt(LocalDateTime.now()); // 값이 추가되어도 변경되면 안 됨!!
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createdAt : %s, modifiedAt : %s", member.getCreatedAt(), member.getModifiedAt());
    } // 날짜 따로 입력 X -> 알아서 들어가 있을 것!
}