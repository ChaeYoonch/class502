package org.choongang.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin { // 커맨드 객체 -> @애노테이션으로 설정 후 기본 검증이 처리 | 안되는 부분은 Validator 를 정의
    @NotBlank
    @Email // 알아서 이메일 형식 검증을 해줌
    private String email; // 이메일

    @NotBlank
    private String password; // 비밀번호

    @NotBlank
    private String confirmPassword; // 비밀번호 확인

    @NotBlank
    private String userName; // 사용자명

    @AssertTrue
    private boolean agree; // 약관 동의
}
/*
public class RequestJoin {
    private String email; // 이메일
    private String password; // 비밀번호
    private String confirmPassword; // 비밀번호 확인
    private String userName; // 사용자명
    // private String[] hobby;
    // private Set<String> hobby;
    // private List<String> hobby; // 취미
    private String hobby; // multiple 추가 되도록 위의 것 지움
    private boolean agree; // 약관 동의

    private Address addr; // 주소 | addr.속성명 으로 입력
}
*/