package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member") // 클래스 명 위에 쓰는 경우가 많음
public class MemberController {

    @GetMapping("/join") // 원래는 "/member/join" 으로 쓰지만, member 부분이 동일하므로 위에 @RequestMapping 에 적용해놓음
    public String join() {

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) {

        return "redirect:/member/join";
    }
    /*
    @RequestMapping(path="/member/join", method = {RequestMethod.GET, RequestMethod.POST}) // GET, POST 둘 다 받을 수 있는 메서드 | 둘 다 없을 때는 모든 메서드 매칭
    public String join(Model model, HttpServletRequest request) {

        model.addAttribute("message", "안녕하세요."); // EL 식 속성으로 접근 가능 | 기존 : request.setAttribute
        System.out.println("method : " + request.getMethod());

        return "member/join";
    } */

    /*
    @GetMapping("/member/join")

    public ModelAndView join() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "안녕하세요.");
        mv.setViewName("/member/join");

        return mv;
    } */
}