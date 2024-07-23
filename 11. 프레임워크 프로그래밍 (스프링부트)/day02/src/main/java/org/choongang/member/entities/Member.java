package org.choongang.member.entities;

import jakarta.persistence.*; // 하위 애노테이션 이므로 * 로 설정하여 Id, Entity, Table 한 번에 작성
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // 관리 데이터로서 확인
// @Table(name="CH_MEMBER")
@Table(indexes = {
        @Index(name = "idx_createdAt_desc", columnList = "createdAt DESC"),
        @Index(name = "uq_email_password", columnList = "email, password", unique = true)}) // 컬럼명 = DB X -> 아래 Member에 정의된 거!
public class Member {
    @Id
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt; // 생성 일자
    private LocalDateTime modifiedAt; // 수정 일자
}