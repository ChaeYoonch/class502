package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 하나의 묶음으로 관리 -> 트랜잭션 처리 필수!
@TestPropertySource(properties = "spring.profiles.active=test") // test 로하지 않으면 oracle db 사용 함
public class Ex02 {

    @PersistenceContext // @Autowired 가능하지만, @PersistenceContext 의미적으로 영속성 컨텍스트이기에 이거 사용
    private EntityManager em;

    @BeforeEach
    void init() {

    }
}