package member;

import lombok.*; // = @Data

import java.time.LocalDateTime;

/* @Getter @Setter @ToString @EqualsAndHashCode */
@Data @AllArgsConstructor @NoArgsConstructor(access=AccessLevel.PRIVATE) // @NoArgsConstructor -> 기본 생성자
public class Member {
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
