package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class MemberProfile { // 기본키는 필수 !!
    @Id
    @GeneratedValue
    private Long seq;
    private String profileImages;
    private String status;

    @ToString.Exclude
    @OneToOne(mappedBy = "profile") // mappedBy -> 관계의 주인 명시함
    private Member member;
}