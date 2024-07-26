package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class Ex13 {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext // 영속성
    private EntityManager em; // (**)

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER) // 짝수 = USER, 홀수 = ADMIN 나오게 할거임
                .build(); // 자동 추가되므로 날짜 & seq 시퀀스 번호 생성 X

        memberRepository.saveAndFlush(member);

        List<BoardData> items = IntStream.rangeClosed(1, 10) // 게시글 10개
                .mapToObj(i -> BoardData.builder()
                        .subject("제목" + i)
                        .content("내용" + i)
                        .member(member)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear(); // 이거 있어야만 쿼리 수행 확인 가능함!
    }

    @Test
    void test1() { // Member 의 cascade = CascadeType.REMOVE 부분 test
        Member member = memberRepository.findById(1L).orElse(null); // 1L : 1번째 게시글
        memberRepository.delete(member); // 위의 member 정보 연동

        memberRepository.flush();
    }

    @Test
    void test2() { // Member 의 {cascade = CascadeType.PERSIST}, orphanRemoval = true 부분 test
        Member member = memberRepository.findById(1L).orElse(null); // 1L : 1번째 게시글

        List<BoardData> items = member.getItems();
        items.remove(0); // 0 번째 있는 값 제거
        items.remove(1); // 1 번째 있는 값 제거

        memberRepository.flush();
    }
}