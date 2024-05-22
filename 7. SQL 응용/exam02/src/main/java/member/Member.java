package member;

import lombok.*; // = @Data 는 @Getter @Setter @ToString @EqualsAndHashCode 4개 모두 담고 있음

import java.time.LocalDateTime;

/* @Getter @Setter @ToString @EqualsAndHashCode 사용 빈도 多 */
@Data @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
// @NoArgsConstructor(access=AccessLevel.PRIVATE) -> 기본 생성자 private 로 접근 제어 범위 설정
public class Member {
    @NonNull // 반드시 초기화가 됨
    private String userId;

    @NonNull
    private String userNm;
    private String email;

    @ToString.Exclude // ToString 메서드에 의해 배제됨
    private LocalDateTime regDt;
}
