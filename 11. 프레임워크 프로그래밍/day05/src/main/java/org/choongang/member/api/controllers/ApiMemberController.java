package org.choongang.member.api.controllers;

import org.choongang.member.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/member")
public class ApiMemberController { // 응답을 JSON 형태로 하는 RestController

    @GetMapping("/info/{email}")
    public Member info() {

    }
}