package member;

import java.time.LocalDateTime;

public class User {

    private String userId; // 객체 직접 생성 X -> 내부에서 생성
    private String userNm;
    private String email;
    private LocalDateTime regDt;

    private User() {} // 직접 생성 X -> 내부에서 생성 => 정적

    public static Builder builder() { // Builder 패턴
        return new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", email='" + email + '\'' +
                ", regDt=" + regDt +
                '}';
    }

    public static class Builder {
        private User user = new User();

        public Builder userId(String userId) {
            user.userId = userId;

            return this; // 본인의 객체 반환 -> 본인이 가지고 있는 것 사용 가능
        }

        public Builder userNm(String userNm) {
            user.userNm = userNm;

            return this;
        }

        public Builder email(String email) {
            user.email = email;

            return this;
        }

        public Builder regDt(LocalDateTime regDt) {
            user.regDt = regDt;

            return this;
        }

        public User build() {
            return user;
        }
    }
}
