package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/member") // 클래스명 위에 쓰는 경우가 많음
@RequiredArgsConstructor
public class MemberController2 {

    /*private final MessageSource messageSource;
    private final HttpServletRequest request;

    @ModelAttribute("commonValue")
    public String commonValue() {
        return "공통 속성 값 ...";
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return List.of("취미1", "취미2", "취미3", "취미4");
    }

    @ModelAttribute("hobbies2")
    public List<CodeValue> hobbies2() {
        return List.of(
                new CodeValue("취미1", "hobby1"),
                new CodeValue("취미2", "hobby2"),
                new CodeValue("취미3", "hobby3"),
                new CodeValue("취미4", "hobby4")
        );
    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {

        Locale locale = request.getLocale(); // 요청 헤더 Accept-Language
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) { // RequestJoin form : 커맨드 객체 -> 데이터 전달 역할

        log.info(form.toString());

        return "member/join"; // 뷰 출력하는 템플릿 객체에서도 데이터 사용 | EL식 param.이름 으로 접근
    }

    @GetMapping("/login")
    public String login(RequestLogin2 form) { // 로그인 페이지

        if (form != null) {
            log.info("이메일:{}, 비밀번호: {}", form.email(), form.password()); // 조회용도 : 상수 형태 -> 값 변경 불가능
        }

        return "member/login";
    }
    /*
    @PostMapping("/join")
    public String joinPs(RequestJoin form) {

        // return "redirect:/member/login"; // Location: /day05/member/login | redirect 있으면, 앞에 / 를 붙여야 절대 경로가 됨, 없으면 상대 경로 | SpringAdaptor 가 실행
        return "forward:/member/login"; // 버퍼 치환
    } */
    // private final Logger log = LoggerFactory.getLogger(MemberController.class);
     /*
    @GetMapping("/join")
    public String join(Model model) { // 회원가입 페이지

        RequestJoin form = new RequestJoin();

        model.addAttribute("requestJoin", form); // 명칭 유지를 위해 requestJoin 빈 객체 = 요청 데이터가 없는 값을 만들어야 함 | 계속 값이 바뀌므로 @Bean 쓰면 안 됨!!

        return "member/join";
    }*/
    /*
    @GetMapping("/join")
    public String join1() {
        log.info("{},{} 없음", "mode1", "mode2"); // System.out.println("mode 없음");
        return "member/join";
    }

    @GetMapping(path="/join", params={"mode=join"}) // 원래는 "/member/join" 으로 쓰지만, member 부분이 동일하므로 위에 @RequestMapping 에 적용해놓음
    public String join() { // params : 요청 데이터를 한정해 놓는 역할
        log.info("mode=join"); // System.out.println("mode=join");
        return "member/join";
    }

    @PostMapping(path="/join", headers="appKey=1234", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) // 요청 헤더 쪽에 한정 : "appKey=1234" 포함되어 있어야만 실행 | consumes = "application/json"
    public String joinPs(RequestJoin form) {

        log.info("joinPs 실행...");

        return "redirect:/member/join";
    } */
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