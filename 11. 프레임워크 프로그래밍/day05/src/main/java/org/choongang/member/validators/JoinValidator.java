package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator { // Validator<RequestJoin>, RequiredValidator -> Validator

    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class); // RequestJoin 커맨드 객체만 검증하도록 제한
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    /*
    @Override
    public void check(RequestJoin form) {
        /**
         * 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree)
         * 2. 이메일 중복 여부 (회원이 가입되어 있는지 체크)
         * 3. 비밀번호 자리 수 체크 (8자리 이상)
         * 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword)
         */

        /* 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree) */
       /* String email = form.getEmail(); // (1)
        String password = form.getPassword(); // (2)
        String confirmPassword = form.getConfirmPassword(); // (3)
        String userName = form.getUserName(); // (4)
        boolean result = form.isAgree(); // (5)

        checkRequired(email, new BadRequestException("이메일을 입력하세요.")); // (1)
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요.")); // (2)
        checkRequired(confirmPassword, new BadRequestException("비밀번호를 확인하세요.")); // (3)
        checkRequired(userName, new BadRequestException("회원명을 입력하세요.")); // (4)

        checkTrue(result, new BadRequestException("약관에 동의하세요.")); // (5) */

        /* 2. 이메일 중복 여부 (회원이 가입되어 있는지 체크) */
        // checkTrue(mapper.exists(email) == 0L, new BadRequestException("이미 가입된 이메일 입니다."));

        /* 3. 비밀번호 자리 수 체크 (8자리 이상) */
        // checkTrue(password.length() >= 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요."));

        /* 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword) */
        // checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호가 일치하지 않습니다."));
}