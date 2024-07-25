package org.choongang.global.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

import java.util.List;

// Spring Data code
@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity { // ORM : 객체 지향적 언어 사용 가능! + 알아서 코딩 가능
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY) // One 쪽이 Member | 외래키가 자동으로 member_seq 로 만들어짐 | 엔티티명_기본키 속성명
    @JoinColumn(name = "mSeq")
    private Member member;

    @Column(nullable = false) // 기본값 255
    private String subject;

    @Lob // CLOB 으로 생성됨
    private String content;

    @ManyToMany
    private List<HashTag> tags;
}