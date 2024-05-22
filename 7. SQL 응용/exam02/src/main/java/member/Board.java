package member;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class Board { // 상수는 반드시 값이 필요 -> 없으면 오류 발생
    private int seq;
    private final String subject;
    private final String content;
    private String poster;

    /* public Board(String subject, String content) {
        this.subject = subject; // 생성자로 초기화 필요!
        this.content = content;
    } */
}
