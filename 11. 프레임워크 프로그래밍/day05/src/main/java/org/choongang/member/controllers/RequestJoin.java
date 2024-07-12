package org.choongang.member.controllers;

import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    private String email; // 이메일
    private String password; // 비밀번호
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 사용자명
    // private String[] hobby; // 취미
    // private Set<String> hobby;
    private List<String> hobby;
    private boolean agree; // 약관 동의
}