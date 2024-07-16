package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice("org.choongang") // () 내부 : 적용 범위
public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class) // () 안은 클래스 class | 원래 : BadRequestException.class | @ExceptionHandler(Exception.class) : 에러 페이지 출력하기 위해 사용
    public ModelAndView errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model) {
        e.printStackTrace();
        log.info("advice 유입");

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 에러 발생 | 예외가 발생하면 전부 여기로 유입됨 | 기본 = 500 으로 고정 / 그 외에 설정해놓은 예외는 각각에 맞는 것 뽑아서 확인
        if (e instanceof CommonException commonException) {
            // CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        ModelAndView mv = new ModelAndView();
        mv.setStatus(status);

        mv.setViewName("error/common");

        return mv;
    }
}