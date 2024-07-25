package org.choongang.global.board.repositories;

import org.choongang.global.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> { // 구현체 = interface 가 정의함 Proxy 로!

}