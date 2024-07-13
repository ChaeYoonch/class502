package org.choongang.user.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/user") // 클래스명 위에 쓰는 경우가 많음
@RequiredArgsConstructor
public class UserController {

    private final MessageSource messageSource;
    private final HttpServletRequest request;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {

        Locale locale = request.getLocale(); // 요청 헤더 Accept-Language
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);

        return "user/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) { // RequestJoin form : 커맨드 객체 -> 데이터 전달 역할

        log.info(form.toString());

        return "user/join"; // 뷰 출력하는 템플릿 객체에서도 데이터 사용 | EL식 param.이름 으로 접근
    }
}