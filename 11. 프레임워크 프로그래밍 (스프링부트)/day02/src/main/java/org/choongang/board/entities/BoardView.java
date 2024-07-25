package org.choongang.board.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class BoardView { // View 카운트 저장 엔티티 | 복합키
    @EmbeddedId
    private BoardViewId id;
}
/*
@IdClass(BoardViewId.class)
public class BoardView {
    @Id // Id 를 묶어주는 클래스 필요 (Id class)
    private long seq;

    @Id
    @Column(name="_uid")  // 이름 변경
    private int uid; // uid = 오라클 예약어
} // 2개를 조합하여 복합키 생성
*/