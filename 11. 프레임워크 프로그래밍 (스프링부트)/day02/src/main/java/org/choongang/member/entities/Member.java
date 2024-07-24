package org.choongang.member.entities;

import jakarta.persistence.*; // 하위 애노테이션 이므로 * 로 설정하여 Id, Entity, Table 한 번에 작성
import lombok.Data;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity // 관리 데이터로서 확인
// @Table(name="CH_MEMBER") | 테이블 명이 클래스명과 다른 경우 -> 직접 설정
/*@Table(indexes = { | 제약조건 -> 인덱스 & 유니크
        @Index(name = "idx_createdAt_desc", columnList = "createdAt DESC"),
        @Index(name = "uq_email_password", columnList = "email, password", unique = true)}) */ // 컬럼명 = DB X -> 아래 Member에 정의된 거!
public class Member { // 클래스 명이 엔티티 명과 동일
    @Id /* 기본키 1개 설정 필수! => 무조건 Id를 1개 넣어야 함! -> 그래야 엔티티 만들어짐 @GeneratedValue(strategy = GenerationType.AUTO) */ @GeneratedValue
    private Long seq;
    private String email;
    private String password;
    private String userName;

    // @Lob
    @Transient // mapping 무시 | 테이블로 만들지 X | 2차 가공해서 넣어줄 데이터
    private String introduction;

    @Enumerated(EnumType.STRING) // 기본값 = EnumType.ORDINAL 이기 때문에 STRING 으로 설정 (의도치 않게 값이 변경되지 않도록 / 문자, 열 그래도 나타냄)
    private Authority authority;

    @CreationTimestamp // hibernate 에서만 가능 | 표준 X | 쿼리 시에 추가
    private LocalDateTime createdAt; // 생성 일자

    @UpdateTimestamp
    private LocalDateTime modifiedAt; // 수정 일자

    @Temporal(TemporalType.DATE) // 날짜만!
    private Date date;
}