package org.choongang.global.advices;

import org.choongang.global.exceptions.CommonException;
import org.choongang.global.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice("org.choongang")
public class RestCommonControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData> errorHandler(Exception e) { // ResponseEntity -> 상세하게 설정

        Object message = e.getMessage(); // 기본 값 = 문자열 메세지

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // default 로 기본 에러 = 500 <- 내가 정의해 놓은 에러가 아닌 경우
        if (e instanceof CommonException commonException) { // 내가 정의해 놓은 (상세하게 적은) 에러인 경우
            status = commonException.getStatus(); // 상태 코드 용도에 따라 달리 정의해 놓은 것 사용

            Map<String, List<String>> errorMessages = commonException.getErrorMessages();
            if (errorMessages != null) message = errorMessages; // errorMessages = 커맨드 객체 검증 -> 커맨드 객체에서 던진 예외
        }

        JSONData data = new JSONData(); // 에러도 형식을 통일성 있게 -> 구현 시 용이하게 만들기 위해 -> 예측 가능하도록 !
        data.setSuccess(false); // 실패했기에
        data.setMessage(e.getMessage());
        data.setStatus(status);

        e.printStackTrace();

        return ResponseEntity.status(status).body(data); // 상태 값도 상세하게 보기 위해
    }
}