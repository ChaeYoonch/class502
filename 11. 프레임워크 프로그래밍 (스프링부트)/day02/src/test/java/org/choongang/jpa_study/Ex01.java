package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test") // application-test.yml 로 실행
public class Ex01 {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    void test1() {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // Transaction 처리 필수

        tx.begin();
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);

        em.flush(); // 처음 추가 -> INSERT 쿼리 실행

        member.setUserName("(수정)사용자01"); // 변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); // 변경 -> UPDATE 쿼리 실행

        tx.commit();
    }
}