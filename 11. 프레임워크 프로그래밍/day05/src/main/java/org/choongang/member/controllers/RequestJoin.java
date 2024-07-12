package org.choongang.member.controllers;

import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    private String email; // 이메일
    private String password; // 비밀번호
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 사용자명
    // private String[] hobby;
    // private Set<String> hobby;
    // private List<String> hobby; // 취미
    private String hobbies; // multiple 추가 되도록 위의 것 지움
    private boolean agree; // 약관 동의

    private Address addr; // 주소 | addr.속성명 으로 입력
}