package org.choongang.survey.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey")
public class SurveyController { // @PostMapping("/step1,2,3") : 다음 페이지로 넘어가는 설문조사 | 이런 형태를 Magic form 이라고 함

    @ModelAttribute
    public RequestSurvey getRequestSurvey()  {
        return new RequestSurvey();
    }

    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestSurvey form) { // get 방식일 때는 앞에 @ModelAttribute 사용해야 함

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2) { // @SessionAttribute("requestSurvey") RequestSurvey form2 : 세션에서 가져온 값 -> 값1,2 유지됨

        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());

        return "survey/step2";
    }

    @PostMapping("/step3")
    public String step3(RequestSurvey form, SessionStatus status) {
        status.setComplete(); // 세션 비우기 - requestSurvey 세션 비우기
        return "survey/step3";
    }
}