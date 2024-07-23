package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional // 알아서 트랜잭션 처리하는 역할
@TestPropertySource(properties = "spring.profiles.active=test") // application-test.yml 로 실행
public class Ex01 {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    void test1() { // 메모리 기반 db 추가 -> 실제 db에 존재 X
        EntityManager em = emf.createEntityManager();

        // EntityTransaction tx = em.getTransaction(); // Transaction 처리 필수

        // tx.begin();
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member); // 영속 상태 - 변화 감지 메모리에 있다! , 변화 감지

        em.flush(); // 처음 추가 -> INSERT 쿼리 실행

        member.setUserName("(수정)사용자01"); // 변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); // 변경 -> UPDATE 쿼리 실행

        em.remove(member); // 제거 상태, 제거 X, 상태만 변경!!
        em.flush(); // DELETE 쿼리

        // tx.commit();
    }
}