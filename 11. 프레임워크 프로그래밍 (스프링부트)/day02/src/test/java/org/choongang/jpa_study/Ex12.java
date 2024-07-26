package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
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

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Tuple> query = queryFactory.select(boardData.subject, boardData.content).from(boardData); // 1개 이면 자료형 사용 O | 데이터가 2개 이상 이면 <Tuple> 사용
        List<Tuple> items = query.fetch();
        for (Tuple item : items) {
            String subject = item.get(boardData.subject);
            String content = item.get(boardData.content);
            System.out.printf("subject=%s, content=%s%n", subject, content);
        }
    }

    @Test
    void test6() {
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum()).from(boardData); // sum : 통계 관련 함수
        long sum = query.fetchOne(); // fetchFirst() : 여러 개 중 한개 -> 여러 개 있어도 상관 없음 | fetchOne() : 한 개만 가져오고 한 개만 있어야 함
        System.out.println(sum);
    }

    @Test
    void test7() {
        QBoardData boardData = QBoardData.boardData;

        BooleanBuilder andBuilder = new BooleanBuilder(); // and 조건
        andBuilder.and(boardData.subject.contains("제목"))
                  .and(boardData.member.email.eq("user01@test.org"));
        /*
        BooleanBuilder orBuilder = new BooleanBuilder(); // or 조건
        orBuilder.or(boardData.seq.eq(2L))
                 .or(boardData.seq.eq(3L))
                 .or(boardData.seq.eq(4L));

        andBuilder.and(orBuilder);
        */
        JPAQuery<BoardData> query = queryFactory.selectFrom(boardData) // in 조건
                                                   .leftJoin(boardData.member)
                                                   .fetchJoin()
                                                   .where(andBuilder)
                                                   .offset(3) // 조회 시작 레코드 3번째 행부터 조회 시작
                                                   .limit(3); // 레코드 3개로 한정 - 개수 제한
                                                   //.where(boardData.seq.in(2L, 3L, 4L)); // 반환값 = BooleanExpression -> 상위가 Predicate | 2L, 3L, 4L = 게시글 2, 3, 4

        List<BoardData> items = query.fetch(); // 위의 fetch 값 연결
        items.forEach(System.out::println);
    }
}