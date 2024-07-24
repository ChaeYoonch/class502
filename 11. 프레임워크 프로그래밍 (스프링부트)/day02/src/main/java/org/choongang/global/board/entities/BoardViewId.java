package org.choongang.global.board.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode // 동일한지 비교하는 것
@AllArgsConstructor // 값을 지정할 수 있는 생성자 | 기본 생성자 필요
@NoArgsConstructor
public class BoardViewId { // BoardView 의 @Id 로 정의한 값과 동일하게 작성
    private long seq; // 매개변수
    private int uid; // 매개변수
}