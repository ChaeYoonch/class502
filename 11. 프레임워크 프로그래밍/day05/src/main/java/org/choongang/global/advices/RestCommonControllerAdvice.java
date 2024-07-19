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
    public ResponseEntity<JSONData> errorHandler(Exception e) {

        Object message = e.getMessage();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        if (e instanceof CommonException commonException) {
            status = commonException.getStatus();

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