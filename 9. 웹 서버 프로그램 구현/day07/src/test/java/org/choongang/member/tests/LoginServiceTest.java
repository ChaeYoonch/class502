package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService; // 객체 조립기 사용 위한 부품 설정
    private Faker faker; // 객체 만들고 사용해야 함

    @Mock
    private HttpServletRequest request; // 모의 객체 - Mockito

    @BeforeEach
    void init() { // 여기서 객체 만들어짐
        loginService = MemberServiceProvider.getInstance().loginService();

        faker = new Faker(Locale.ENGLISH);

        setData(); // 데이터 호출
    }

    void setData() { // 데이터 초기화 - 비밀번호 검증에는 이메일이 필요하므로 void init() 에서 분리함
        setParam("email", faker.internet().emailAddress()); // 임시
        setParam("password", faker.regexify("\\w{8}").toLowerCase());
    }

    void setParam(String name, String value) {// 가짜 데이터를 만들 수 있는 메서드 | 가짜 데이터 - Stub
        given(request.getParameter(name)).willReturn(value); // name 이라는 파라미터가 나오면 value 값 반환
    }

    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest() { // 예외가 발생 x = assertDoesNotThrow() 사용
        assertDoesNotThrow(() -> {
            loginService.process(request); // process = LoginService 파일의 public void process() {} 의미함
        });
    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패시 BadRequestException 발생")
    void requiredFieldTest() {

    }

    void requiredEachFieldTest(String name, boolean isNull, String message) {
        setData(); // 값 초기화 - 이메일 & 비밀번호 둘 다 값이 들어갈 수 있도록!
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            if (name.equals("password")) { // 비밀번호 검증
                setParam("password", isNull?null:"     "); // Null 일 때는 null 값을 , 아닐 때는 빈 값을 넣어줌
            } else { // 이메일 검증
                setParam("email", isNull?null:"     "); // Null 일 때는 null 값을 , 아닐 때는 빈 값을 넣어줌
            }
            loginService.process(request); // 호출
        }, name + "테스트");

        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), name + ", 키워드 : " + message + "테스트");
    }
}