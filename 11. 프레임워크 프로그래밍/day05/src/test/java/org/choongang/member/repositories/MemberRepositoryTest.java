package org.choongang.member.repositories;

import org.choongang.config.MvcConfig;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

@SpringJUnitWebConfig // 웹 설정 O | @ExtendWith 포함 O
@ContextConfiguration(classes = MvcConfig.class)
public class MemberRepositoryTest {

    @Autowired // 의존성 주입 = DAO 대신하는 애
    private MemberRepository repository;

    @Test
    void test1() {
        List<Member> members = (List<Member>) repository.findAll(); // 전체 목록 조회
        members.forEach(System.out::println);
    }

    @Test
    void test2() {

    }
}