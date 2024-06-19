package org.choongang.member.tests;

import org.choongang.member.services.JoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    @Test
    @DisplayName("회원가입 성공 시 예외가 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(() -> {
            JoinService service = new JoinService();
            service.process(); // process 는 JoinService 의 public void process() { } 를 의미함
        });
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {

    }
}
