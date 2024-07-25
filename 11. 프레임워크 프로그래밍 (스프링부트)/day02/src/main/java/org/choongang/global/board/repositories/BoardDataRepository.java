package org.choongang.global.board.repositories;

import org.choongang.global.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> { // 구현체 = interface 가 정의함 Proxy 로! | <BoardData> = 자료형

    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member")
    List<BoardData> getAllList();
}