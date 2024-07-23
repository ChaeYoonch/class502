package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // 관리 데이터로서 확인
public class Member {
    @Id
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt; // 생성 일자
    private LocalDateTime modifiedAt; // 수정 일자
}