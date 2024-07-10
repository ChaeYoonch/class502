package member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(@RequestParam(name="name", defaultValue = "기본값") String name) {
        System.out.println("name : " + name);
        return "member/join"; // "/WEB-INF/templates/", " 형태로 join.jsp 를 의미함
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form) { // () 안에 RequestJoin 넣으면 됨
        System.out.println(form);
        return "member/join";
    }
}