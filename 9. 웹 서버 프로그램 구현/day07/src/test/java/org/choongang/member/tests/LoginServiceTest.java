package org.choongang.member.tests;

import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService; // 객체 조립기 사용 위한 부품 설정

    @BeforeEach
    void init() {
        loginService = MemberServiceProvider.getInstance().loginService();
    }

    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest() { // 예외가 발생 x = assertDoesNotThrow() 사용
        assertDoesNotThrow(() -> {
            LoginService loginService = new LoginService();
            loginService.process(); // process = LoginService 파일의 public void process() {} 의미함
        });
    }
}
