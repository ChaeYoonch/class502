package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional // 하나의 묶음으로 관리 -> 트랜잭션 처리 필수!
@TestPropertySource(properties = "spring.profiles.active=test") // test 로하지 않으면 oracle db 사용 함
public class Ex02 {

    @PersistenceContext // @Autowired 가능하지만, @PersistenceContext 의미적으로 영속성 컨텍스트이기에 이거 사용
    private EntityManager em;

    @BeforeEach
    void init() {
        for (long i = 1L; i <= 10L; i++) {
            Member member = new Member();
            member.setSeq(i);
            member.setEmail("user01" + i + "@test.org");
            member.setPassword("12345678");
            member.setUserName("사용자01" + i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); // 영속 상태가 됨! | 처음 만들고 처음 생성한 객체!
        }

        em.flush(); // DB 영구 반영
        em.flush(); // 영속 상태 엔티티 모두 비우기
    }

    @Test
    void test1() {
        Member member = em.find(Member.class, 1L); // 영속성 상태의 Member 로 조회 | 찾는 기준 = 기본키
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L); // 영속성 상태의 Member 로 조회
        System.out.println(member2);

        System.out.println(member == member2);
        System.out.println("member : " + System.identityHashCode(member));
        System.out.println("member2 : " + System.identityHashCode(member2));
    }
}