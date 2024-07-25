package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "profile")
    private Member member;
}