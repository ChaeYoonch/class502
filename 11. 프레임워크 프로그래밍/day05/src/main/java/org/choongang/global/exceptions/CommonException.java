package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter // BadRequestException 에서 setErrorMessage 썼기에 연결하기 위해 추가함
public class CommonException extends RuntimeException { // 공통 예외 부분

    private HttpStatus status; // spring 에서 제공하는 Enum 클래스 (상수)

    private Map<String, List<String>> errorMessages; // 커맨드 객체 검증 실패 시 에러 전용 필드 생성 | 값 조회 & 수정 위해 @Getter, @Setter 추가함

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500 에러 발생
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}