package org.choongang.board.repositories;

import org.choongang.board.entities.BoardData;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> { // 구현체 = interface 가 정의함 Proxy 로! | <BoardData> = 자료형

    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member")
    List<BoardData> getAllList();

    @EntityGraph(attributePaths = "member") // BoardData 의 private Member member 부분 속성명 입력
    List<BoardData> findBySubjectContaining(String key);
}