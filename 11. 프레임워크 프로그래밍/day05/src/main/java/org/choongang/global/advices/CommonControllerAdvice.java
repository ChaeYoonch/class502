package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.BadRequestException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice("org.choongang") // () 내부 : 적용 범위
public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class) // () 안은 클래스 class | 원래 : BadRequestException.class
    public String errorHandler(BadRequestException e, HttpServletRequest request, HttpServletResponse response, Model model) {
        e.printStackTrace();
        log.info("advice 유입");
        return "error/common"; // common = common.jsp
    }
}