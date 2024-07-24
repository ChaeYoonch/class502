package org.choongang.member.entities;

import jakarta.persistence.*; // 하위 애노테이션 이므로 * 로 설정하여 Id, Entity, Table 한 번에 작성
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;

@Builder
@Data
@Entity // 관리 데이터로서 확인
@NoArgsConstructor
@AllArgsConstructor
// @Table(name="CH_MEMBER") | 테이블 명이 클래스명과 다른 경우 -> 직접 설정
/*@Table(indexes = { | 제약조건 -> 인덱스 & 유니크
        @Index(name = "idx_createdAt_desc", columnList = "createdAt DESC"),
        @Index(name = "uq_email_password", columnList = "email, password", unique = true)}) */ // 컬럼명 = DB X -> 아래 Member에 정의된 거!
public class Member extends BaseEntity { // 클래스 명이 엔티티 명과 동일
    @Id /* 기본키 1개 설정 필수! => 무조건 Id를 1개 넣어야 함! -> 그래야 엔티티 만들어짐 @GeneratedValue(strategy = GenerationType.AUTO) */ @GeneratedValue
    private Long seq;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 65, nullable = false) // nullable = not null -> 필수 항목
    private String password;

    @Column(length = 40, nullable = false, name="name") // DB Table 에는 userName 대신 name 으로 들어가 있음 | nullable = not null -> 필수 항목
    private String userName;

    // @Lob
    @Transient // mapping 무시 | 테이블로 만들지 X | 2차 가공해서 넣어줄 데이터
    private String introduction;

    @Column(length = 10)
    @Enumerated(EnumType.STRING) // 기본값 = EnumType.ORDINAL 이기 때문에 STRING 으로 설정 (의도치 않게 값이 변경되지 않도록 / 문자, 열 그대로 나타냄)
    private Authority authority;
    // 여기 있던 2개 BaseEntity 로 이동 -> 상속으로 연동

    /* @Temporal(TemporalType.DATE) // 날짜만!
    private Date date; */
}