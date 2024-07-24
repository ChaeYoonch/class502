package org.choongang.global.board.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BoardView { // View 카운트 저장 엔티티 | 복합키
    @Id
    private long seq;

    @Id
    private int uid; // 2개를 조합하여 복합키 생성
}