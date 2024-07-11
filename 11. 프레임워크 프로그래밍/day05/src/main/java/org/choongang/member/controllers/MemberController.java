package org.choongang.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MemberController {

    // @GetMapping("/member/join")
    @RequestMapping(path="/member/join", method = {RequestMethod.GET, RequestMethod.POST}) // GET, POST 둘 다 받을 수 있는 메서드 | 둘 다 없을 때는 모든 메서드 매칭
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