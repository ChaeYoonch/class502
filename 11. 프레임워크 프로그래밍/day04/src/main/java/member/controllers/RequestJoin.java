package member.controllers;

import lombok.Data;

@Data
public class RequestJoin {
    private String email; // 이메일
    private String password; // 비밀번호
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 사용자명
    private boolean agree; // 약관 동의
}