package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class BadRequestException extends CommonException { // 응답 코드 400으로 고정
    public BadRequestException(String message) { // BadRequestException = 기본 생성자
        super(message, HttpStatus.BAD_REQUEST); // 400 에러 발생
    }

    public BadRequestException(Map<String, List<String>> errorMessages) {
        super(null, HttpStatus.BAD_REQUEST);
        setErrorMessages(errorMessages); // CommonException 에 정의된 errorMessages 연동
    }
}