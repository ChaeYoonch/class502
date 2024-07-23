package org.choongang.jpa_study;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test") // application-test.yml 로 실행
public class Ex01 {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    void test1() {

    }
}