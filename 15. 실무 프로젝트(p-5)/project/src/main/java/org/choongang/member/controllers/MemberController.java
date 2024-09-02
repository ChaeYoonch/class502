package org.choongang.member.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.choongang.member.entities.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name= "Member", description = "회원 API")
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @PostMapping
    public ResponseEntity<Member> join(@RequestBody RequestJoin form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Member()); // 요청 데이터, 응답 데이터 자동 추가됨
    }
}