package org.choongang.member.repositories;

import org.choongang.config.MvcConfig;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

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
        Member member = Member.builder()
                            .seq(1L)
                            .email("user01@test.org")
                            .password("12345678")
                            .userName("사용자06(수정)")
                            .build();

        repository.save(member); // DB table 에 값 추가 | 이미 있으면 수정, 없으면 추가
    }

    @Test
    void test3() {
        Member member = repository.findById(1L).orElse(null);
        System.out.println(member);

        repository.delete(member);
    }

    @Test
    void test4() {
        Member member = repository.findByEmail("user02@test.org");
        System.out.println(member);
    }

    @Test
    void test5() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Member> members = repository.findByUserNameContaining("용자", pageable);
        members.forEach(System.out::println);
    }

    @Test
    void test6() {
        List<Member> members = repository.findByUserNameContainingAndEmailContainingOrderByRegDtDesc("용자", "user");
        members.forEach(System.out::println);
    }

    @Test
    void test7() {
        List<Member> members = repository.getMembers("용자", "user");
        members.forEach(System.out::println);
    }

    @Test
    void test8() {
        // Pageable pageable = PageRequest.of(0, 3); // 1 페이지당 3개씩 나옴 | Order = Sort 의 정적 내부 클래스 - Sort.Order.desc
        Pageable pageable = PageRequest.of(0, 3, Sort.by(desc("regDt"), asc("email")));
        Page<Member> data = repository.findByUserNameContaining("용자", pageable);

        List<Member> members = data.getContent();

        long total = data.getTotalElements(); // 조회된 전체 레코드 개수
        int pages = data.getTotalPages(); // 전체 페이지 개수

        members.forEach(System.out::println);

        System.out.printf("총 개수 : %d, 총 페이지 수 : %d%n", total, pages);
    }
}