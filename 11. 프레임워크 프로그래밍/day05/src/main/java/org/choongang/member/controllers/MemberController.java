package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j // log.() 사용할 수 있게 추가함
@Controller // controller 로 동작
@RequestMapping("/member") // 공통으로 매핑될 주소 | 클래스명 위에 주로 위치함
@RequiredArgsConstructor // 의존성 주입 -> 생성자 매개변수로 주입
public class MemberController {

    private final JoinValidator joinValidator; // 의존성은 바뀌지 않기에 final 로 작성
    private final JoinService joinService;

    private final LoginValidator loginValidator;
    private final LoginService loginService; // 의존성 주입

    @GetMapping("/join")
    public String  join(@ModelAttribute RequestJoin form) { // @ModelAttribute 자료형이 EL 식 속성 | @ModelAttribute : 공통 값 설정

        return "member/join";
    }

    @PostMapping("/join")     // 얘 검증하므로 JoinValidator 의 validate() 부분 ()안에 넣는 거임!
    public String joinPs(@Valid RequestJoin form, Errors errors) { // joinPs = joinProcess | JoinValidator 의 supports() 의 커맨드 객체로 RequestJoin 이 넘어옴 | @Valid : 얘가 검증해줌 | RequestJoin form, Errors errors 얘네 순서 바뀌면 안됨 | 중복 회원 체크, 비밀번호 체크 2개만 추가로 설정함
        // 회원 가입 데이터 검증
        joinValidator.validate(form, errors); // -> @Valid 로 설정하여 JoinValidator 가 검증하므로 필요 없음

        if (errors.hasErrors()) { // reject 나 rejectValue 가 한 번이라도 호출되면 true | 검증 실패시 과정
            return "member/join"; // 메세지 호출 시 hasErrors 로 이동
        }

        joinService.process(form); // 회원 가입 처리

        return "redirect:/member/login"; // 문구 형태로 입력해도 이동할 수 있음
    }
    /* @InitBinder
    public void initBinder(WebDataBinder binder) { // 위의 @Valid 부분을 얘가 정의함 | 컨트롤러 안에서 정의하는 공통 Validator | joinValidator.validate(form, errors); 가 하던 역할을 하는 거임!!
        binder.setValidator(joinValidator);
    } */

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name = "savedEmail", required = false) String savedEmail)
                        /* @SessionAttribute(name="member", required = false) Member member) */{
        /*
        if (member != null) {
            log.info(member.toString());
        } */
        if (savedEmail != null) {
        form.setSaveEmail(true);
        form.setEmail(savedEmail);
        }

        return "/member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors /* HttpServletRequest request */) { // 로그인 처리 | 1차 검증
        // HttpSession session = request.getSession(); // 불러올 때 세션 객체 생성
        loginValidator.validate(form, errors); // 2차 검증

        if (errors.hasErrors()) {
            return "member/login"; // 에러 발생시 로그인 페이지로 이동
        }

        // String email = form.getEmail(); -> 로그인 처리
        loginService.process(form);

        return "redirect:/";
    }

    /* 로그아웃 기능 */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기 -> 회원가입 값이 사라지므로 로그아웃이라고 볼 수 있음

        return "redirect:/member/login";
    }

    @GetMapping("/list")
    public String list(@Valid @ModelAttribute MemberSearch search, Errors errors) { // 회원가입 날짜로 조회 | @Valid : 검증이 필요한 형태야! 라는 의미

        log.info(search.toString());

        return "member/list";
    }
}