package member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController { // @Autowired 로 컨테이너 안에 객체를 담음

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession session;

    @GetMapping("/member/join")
    public String join(@RequestParam(name="name", defaultValue = "기본값") String name) {
        System.out.println("name : " + name);
        return "member/join"; // "/WEB-INF/templates/", " 형태로 join.jsp 를 의미함
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, Errors errors) { // () 안에 RequestJoin 넣으면 됨
        System.out.println(form);
        return "member/join";
    }
}