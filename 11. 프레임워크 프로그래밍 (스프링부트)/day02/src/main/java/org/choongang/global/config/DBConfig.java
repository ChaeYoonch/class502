package org.choongang.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class DBConfig { // DB 설정

    @PersistenceContext
    private EntityManager em; // (*)

    @Lazy // 처음 사용할 때 만들어지고 싱글톤으로 관리 & 공유
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em); // (*) 연동
    }
}