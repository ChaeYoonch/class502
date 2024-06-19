package org.choongang.member.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member { // VO class | DB에 있는 항목 그대로 작성
    private long userNo; // 회원번호
    private String email; // 이메일
    private String password; // 비밀번호
    private String userName; // 회원명
    private LocalDateTime regDt; // 회원 가입 일자
    private LocalDateTime modDt; // 회원 정보 수정
}
