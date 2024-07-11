package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException { // 공통 예외 부분

    private HttpStatus status; // spring 에서 제공하는 Enum 클래스 (상수)

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}