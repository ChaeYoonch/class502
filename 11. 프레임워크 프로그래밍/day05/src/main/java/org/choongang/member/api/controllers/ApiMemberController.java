package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.rests.JSONData;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping // POST /api/member
    public ResponseEntity join(@RequestBody RequestJoin form) { // form 데이터 받아옴
        // log.info(form.toString());
        joinService.process(form);
        // 응답 코드가 201 이고, 출력 바디 없음
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info/{email}")
    public JSONData info(@PathVariable("email") String email) { // public Member info(@PathVariable("email") String email) = ResponseEntity<Member> info() {} 와 동일
        // Content-Type : application/json
        Member member = mapper.get(email); //         -> 요기 email 가져온 것

        // return member;
        // return ResponseEntity.ok(member); -> 응답 코드 200
        return new JSONData(member); // 형식 고정 | 위의 member 가져옴
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                                    .email("user" + i + "@test.org")
                                    .password("12345678")
                                    .userName("사용자" + i)
                                    .regDt(LocalDateTime.now())
                                    .build())
                .toList();

        HttpHeaders headers = new HttpHeaders(); // 헤더
        headers.add("t1", "v1");
        headers.add("t2", "v2");

        // return ResponseEntity.status(HttpStatus.OK).body(members); // List<Member> members 의 members 가져옴
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(members);
        return new ResponseEntity<>(members, headers, HttpStatus.OK); // body, header, 응답 코드 순서
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