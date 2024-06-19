package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestJoin { // DTO - 필수 항목 설정
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean termsAgree;
}