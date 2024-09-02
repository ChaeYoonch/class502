package org.choongang.member.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name= "Member", description = "회원 API")
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
}