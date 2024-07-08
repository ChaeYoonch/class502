package member.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestJoin { // DTO - 회원가입에서 필요한 항목
    private String email;
    private String password;
    private String ConfirmPassword;
    private String userName;
    private LocalDateTime RegDt;
}