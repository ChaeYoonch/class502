package member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder @ToString
// @NoArgsConstructor(access = AccessLevel.PUBLIC)
// 기본 생성자를 꼭 써야 되는 경우 @NoArgsConstructor @AllArgsConstructor 사용하면 됨
@NoArgsConstructor @AllArgsConstructor
public class User2 {

    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
