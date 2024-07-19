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

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 기본 에러 = 500 <- 내가 정의해 놓은 에러가 아닌 경우
        if (e instanceof CommonException commonException) { // 내가 정의해 놓은 에러인 경우
            status = commonException.getStatus(); // 상태 코드 정의해 놓은 것 사용

            Map<String , List<String>> errorMessages = commonException.getErrorMessages();
            if (errorMessages != null) message = errorMessages;
        }

        JSONData data = new JSONData(); // 형식을 통일성 있게 -> 구현 시 용이하게 만들기 위해 -> 예측 가능하도록 !
        data.setSuccess(false);
        data.setMessage(e.getMessage());
        data.setStatus(status);

        e.printStackTrace();

        return ResponseEntity.status(status).body(data);
    }
}