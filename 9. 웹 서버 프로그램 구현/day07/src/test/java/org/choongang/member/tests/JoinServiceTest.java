package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.choongang.global.configs.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService service;
    private MemberMapper mapper;

    @BeforeEach
    void init() { // @BeforeEach 로 초기화 작업 실행
        // service = new JoinService(new JoinValidator());
        service = MemberServiceProvider.getInstance().joinService(); // 완성된 객체로 바로 가져옴
        mapper = DBConn.getSession().getMapper(MemberMapper.class);
    }

    RequestJoin getData() {
        Faker faker = new Faker(Locale.ENGLISH);

        RequestJoin form = RequestJoin.builder() // 회원가입 데이터 설정
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8}").toLowerCase())
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();
        form.setConfirmPassword(form.getPassword()); // 비밀번호 확인 = 비밀번호와 동일

        return form;
    }

    @Test
    @DisplayName("회원가입 성공 시 예외가 발생하지 않음")
    void successTest() {
        RequestJoin form = getData();
        assertDoesNotThrow(() -> {
            service.process(form); // process 는 JoinService 의 public void process() { } 를 의미함
        });

        // 가입된 이메일로 회원이 조회되는지 체크
        Member member = mapper.get(form.getEmail());
        assertEquals(form.getEmail(), member.getEmail()); // form 의 getEmail 과 member 의 getEmail 이 같은지 확인
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {
        assertAll(
                () -> requiredEachFieldTest("email", true, "이메일"), // 이메일
                () -> requiredEachFieldTest("email", false, "이메일"), // 이메일
                () -> requiredEachFieldTest("password", true, "비밀번호"), // 비밀번호
                () -> requiredEachFieldTest("password", false, "비밀번호"), // 비밀번호
                () -> requiredEachFieldTest("confirmPassword", true, "비밀번호를 확인"), // 비밀번호 확인
                () -> requiredEachFieldTest("confirmPassword", false, "비밀번호를 확인"), // 비밀번호 확인
                () -> requiredEachFieldTest("userName", true, "회원명"), // 회원명
                () -> requiredEachFieldTest("userName", false, "회원명"), // 회원명
                () -> requiredEachFieldTest("termsAgree", false, "약관") // 약관 동의
        );
    }

    void requiredEachFieldTest(String field, boolean isNull, String keyword) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            RequestJoin form = getData();
            if (field.equals("email")) {
                form.setEmail(isNull?null:"    "); // null 이면 null 을 null 이 아니면 빈 값을
            } else if (field.equals("password")) {
                form.setPassword(isNull?null:"    ");
            } else if (field.equals("confirmPassword")) {
                form.setConfirmPassword(isNull?null:"    ");
            } else if (field.equals("userName")) {
                form.setUserName(isNull?null:"    ");
            } else if (field.equals("termsAgree")) {
                form.setTermsAgree(false);
            }

            service.process(form);

        }, field + "테스트");

        String message = thrown.getMessage();
        assertTrue(message.contains(keyword), field + "키워드 테스트");
    }

    @Test
    @DisplayName("비밀번호 와 비밀번호 확인이 일치하지 않으면 BadRequestException 발생")
    void passwordMismatchTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            RequestJoin form = getData();
            form.setConfirmPassword(form.getPassword() + "**");
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("이메일이 형식에 맞는지 체크, 형식이 맞지 않으면 BadRequestException 발생")
    void emailPatternTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, ()-> {
            RequestJoin form = getData();
            form.setEmail("******");
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 형식이"));
    }

    @Test
    @DisplayName("비밀번호 자리수가 8자리 미만이면 BadRequestException 발생")
    void passwordLengthTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            Faker faker = new Faker();
            RequestJoin form = getData();
            form.setPassword(faker.regexify("\\w{3,7}").toLowerCase());
            form.setConfirmPassword(form.getPassword());
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("8자리 이상"));
    }

    @Test
    @DisplayName("이미 가입된 메일인 경우, DuplicatedException 발생")
    void duplicateEmailTest() {
        MemberServiceProvider provider = MemberServiceProvider.getInstance();
        assertThrows(DuplicatedMemberException.class, () -> {
            RequestJoin form = getData();
            provider.joinService().process(form);
            provider.joinService().process(form);
        });
    }
}