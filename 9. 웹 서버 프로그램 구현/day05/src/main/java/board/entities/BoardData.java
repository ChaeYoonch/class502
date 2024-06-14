package board.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardData { // MVC model 에서 C 담당
    private long seq; // 번호
    private String subject; // 제목
    private String content; // 내용
    private String poster; // 작성자
    private LocalDateTime regDt; // 작성일
}
