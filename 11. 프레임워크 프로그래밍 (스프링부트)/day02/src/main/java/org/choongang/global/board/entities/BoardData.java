package org.choongang.global.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity { // ORM : 객체 지향적 언어 사용 가능! + 알아서 코딩 가능
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne // One 쪽이 Member
    private Member member;

    @Column(nullable = false) // 기본값 255
    private String subject;

    @Lob // CLOB 으로 생성됨
    private String content;
}