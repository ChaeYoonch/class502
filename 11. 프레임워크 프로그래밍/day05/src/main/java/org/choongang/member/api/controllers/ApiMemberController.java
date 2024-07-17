package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ApiMemberController { // 응답을 JSON 형태로 하는 RestController

    private final MemberMapper mapper;
    private final JoinService joinService;

    public void join(RequestJoin form) { // form 데이터 받아옴

    }

    @GetMapping("/info/{email}")
    public Member info(@PathVariable("email") String email) {
        // Content-Type : application/json
        Member member = mapper.get(email); //         -> 요기 email 가져온 것

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                                    .email("user" + i + "@test.org")
                                    .password("12345678")
                                    .userName("사용자" + i)
                                    .regDt(LocalDateTime.now())
                                    .build())
                .toList();

        return members;
    }

    @GetMapping(path="/test", produces = "text/html;charset=UTF-8")
    public String test() {
        // Content-Type : text/plain
        return "안녕하세요!";
    }

    @GetMapping("/test2")
    public void test2() {
        log.info("test2....");
    }
}