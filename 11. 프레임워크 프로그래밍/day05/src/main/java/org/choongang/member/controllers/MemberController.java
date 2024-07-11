package org.choongang.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(Model model) {
        model.addAttribute("message", "안녕하세요."); // EL 식 속성으로 접근 가능 | 기존 : request.setAttribute

        return "member/join";
    }

    /*
    @GetMapping("/member/join")

    public ModelAndView join() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "안녕하세요.");
        mv.setViewName("/member/join");

        return mv;
    } */
}