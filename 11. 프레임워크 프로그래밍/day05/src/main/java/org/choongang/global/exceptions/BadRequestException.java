package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class BadRequestException extends CommonException { // 응답 코드 400으로 고정 | 일반 메세지 형태에서 던진 것
    public BadRequestException(String message) { // BadRequestException = 기본 생성자
        super(message, HttpStatus.BAD_REQUEST); // 400 에러 발생
    }

    public BadRequestException(Map<String, List<String>> errorMessages) { // 생성자 매개 변수에 추가 -> 커맨드 객체 에서 던진 것
        super(null, HttpStatus.BAD_REQUEST);
        setErrorMessages(errorMessages); // CommonException 에 정의된 errorMessages 연동 -> setter 함수로 상속받은 CommonException 연결
    }
}