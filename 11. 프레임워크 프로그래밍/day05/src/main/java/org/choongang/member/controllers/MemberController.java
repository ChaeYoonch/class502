package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller 로 동작
@RequestMapping("/member") // 공통으로 매핑될 주소 | 클래스명 위에 주로 위치함
@RequiredArgsConstructor // 의존성 주입 -> 생성자 매개변수로 주입
public class MemberController {

    private final JoinValidator joinValidator; // 의존성은 바뀌지 않기에 final 로 작성

    @GetMapping("/join")
    public String  join(@ModelAttribute RequestJoin form) { // @ModelAttribute 자료형이 EL 식 속성

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) { // joinProcess | JoinValidator 의 supports() 의 커맨드 객체로 RequestJoin 이 넘어옴

        return "redirect:/member/login"; // 문구 형태로 입력해도 이동할 수 있음
    }
}