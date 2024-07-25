package org.choongang.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DBConfig { // DB 설정

    @PersistenceContext
    private EntityManager em; // (*)

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em); // (*) 연동
    }
}