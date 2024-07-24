package org.choongang.global.board.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class BoardView { // View 카운트 저장 엔티티 | 복합키
    private long seq;
}