package org.choongang.jpa_study;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.QBoardData;
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
@ActiveProfiles("test")
@Transactional
public class Ex12 {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

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
    void test1() {
        List<BoardData> items = boardDataRepository.findAll(); // 게시글 10개 전체 조회

        for (BoardData item : items) { // 회원 별 쿼리 수행
            Member member = item.getMember();
            String email = member.getEmail();
            String userName = member.getUserName();
            System.out.printf("email=%s, userName=%s%n", email, userName);
        }
    }

    @Test
    void test2() {
        List<BoardData> items = boardDataRepository.getAllList();
    }

    @Test
    void test3() {
        List<BoardData> items = boardDataRepository.findBySubjectContaining("제목");
    }

    @Test
    void test4() {
        QBoardData boardData = QBoardData.boardData;

        // JPAQueryFactory factory = new JPAQueryFactory(em); // em = (**) 연동함
        JPAQuery<BoardData> query = queryFactory.selectFrom(boardData) // JPAQuery<BoardData> query = factory
                                           .leftJoin(boardData.member)
                                           .fetchJoin();

        List<BoardData> items = query.fetch();
        //items.forEach(System.out::println);
    }
}