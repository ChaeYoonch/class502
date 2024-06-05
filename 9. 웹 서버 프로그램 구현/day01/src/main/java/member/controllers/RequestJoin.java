package member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 사용자 이름
    private boolean termsAgree; // 약관 동의
}
