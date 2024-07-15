package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller 로 동작
@RequestMapping("/member") // 공통으로 매핑될 주소 | 클래스명 위에 주로 위치함
@RequiredArgsConstructor // 의존성 주입 -> 생성자 매개변수로 주입
public class MemberController {

}