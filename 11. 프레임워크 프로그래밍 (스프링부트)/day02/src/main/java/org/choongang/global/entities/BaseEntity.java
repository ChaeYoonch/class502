package org.choongang.global.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // @MappedSuperclass 는 @EntityListeners 필수 <- 이벤트 감시용
public abstract class BaseEntity { // 얘 자체로 객체 생성 X -> abstract class 추상 클래스로 정의

    @CreatedDate // hibernate 에서만 가능 | 표준 X | 쿼리 시에 추가
    private LocalDateTime createdAt; // 생성 일자 | 처음 추가하고 수정하면 안 됨!!

    @LastModifiedDate
    private LocalDateTime modifiedAt; // 수정 일자 | 수정할 때만 값이 들어감
}