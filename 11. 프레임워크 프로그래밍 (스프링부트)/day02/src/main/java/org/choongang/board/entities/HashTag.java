package org.choongang.board.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
public class HashTag {
    @Id
    private String tag;

    // @ToString.Exclude // 배제
    // @ManyToMany(mappedBy = "tags") // 관계의 주인 설정
    // private List<BoardData> items;
}