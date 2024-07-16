package org.choongang.survey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController { // @PostMapping("/step1,2,3") : 다음 페이지로 넘어가는 설문조사

    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestSurvey form) { // get 방식일 때는 앞에 @ModelAttribute 사용해야 함

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form) {

        return "survey/step2";
    }

    @PostMapping("/step3")
    public String step3(RequestSurvey form) {

        return "survey/step3";
    }
}