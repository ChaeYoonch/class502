package org.choongang.jpa_study;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test") // 테스트별로 위에 @Test 붙이지 않아도 됨
@Transactional
public class Ex08 {
    @PersistenceContext // 의존성 주입
    private EntityManager em;
}