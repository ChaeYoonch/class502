package org.choongang.global.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
public abstract class BaseEntity { // 얘 자체로 객체 생성 X -> abstract class 추상 클래스로 정의
    @CreationTimestamp // hibernate 에서만 가능 | 표준 X | 쿼리 시에 추가
    private LocalDateTime createdAt; // 생성 일자

    @UpdateTimestamp
    private LocalDateTime modifiedAt; // 수정 일자
}