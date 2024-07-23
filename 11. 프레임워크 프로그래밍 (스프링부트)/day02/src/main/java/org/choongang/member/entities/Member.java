package org.choongang.member.entities;

import jakarta.persistence.*; // 하위 애노테이션 이므로 * 로 설정하여 Id, Entity, Table 한 번에 작성
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // 관리 데이터로서 확인
@Table
public class Member {
    @Id
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt; // 생성 일자
    private LocalDateTime modifiedAt; // 수정 일자
}