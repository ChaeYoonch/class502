package org.choongang.user.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.user.controllers.RequestJoin;
import org.choongang.user.mappers.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, RequiredValidator {

    private final UserMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestJoin.class.isAssignableFrom(clazz); // RequestJoin 커맨드 객체만 검증하도록 제한
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestJoin form = (RequestJoin) target;

        /**
         * 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree)
         * 2. 이메일 중복 여부 (회원 가입 여부 체크)
         * 3. 비밀번호 자리 수 체크 (8자리 이상)
         * 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword)
         */

        /* 1. 필수 항목 검증 (email (1), password (2), confirmPassword (3), userName (4), agree (5)) */
        String email = form.getEmail(); // (1)
        String password = form.getPassword(); // (2)
        String confirmPassword = form.getConfirmPassword(); // (3)
        String userName = form.getUserName(); // (4)
        boolean result = form.isAgree(); // (5)

        try {
            checkRequired(email, new BadRequestException("이메일 입력!")); // (1)
            checkRequired(password, new BadRequestException("비밀번호 입력!")); // (2)
            checkRequired(confirmPassword, new BadRequestException("비밀번호 확인!")); // (3)
            checkRequired(userName, new BadRequestException("회원명 입력!")); // (4)

            checkTrue(result, new BadRequestException("약관에 동의함")); // (5)

            /* 2. 이메일 중복 여부 (회원 가입 여부 체크) */
            checkTrue(mapper.exists(email) == 0L, new BadRequestException("해당 이메일 이미 가입되어 있음"));

            /* 3. 비밀번호 자리 수 체크 (8자리 이상) */
            checkTrue(password.length() >= 8, new BadRequestException("비밀번호 8자리 이상 입력!"));

            /* 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword) */
            checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호 불일치!"));
        } catch (BadRequestException e) {
            errors.rejectValue("field", "error.code", e.getMessage());
        }
    }

    // public void check(RequestJoin form) {}
}


/*package org.choongang.user.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.user.controllers.RequestJoin;
import org.choongang.user.mappers.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {

    private final UserMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class); // RequestJoin 커맨드 객체만 검증하도록 제한
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public void check(RequestJoin form) {
        /**
         * 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree)
         * 2. 이메일 중복 여부 (회원 가입 여부 체크)
         * 3. 비밀번호 자리 수 체크 (8자리 이상)
         * 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword)
         */

//import org.choongang.global.exceptions.BadRequestException;/* 1. 필수 항목 검증 (email (1), password (2), confirmPassword (3), userName (4), agree (5)) */
        /*String email = form.getEmail(); // (1)
        String password = form.getPassword(); // (2)
        String confirmPassword = form.getConfirmPassword(); // (3)
        String userName = form.getUserName(); // (4)
        boolean result = form.isAgree(); // (5)

        checkRequired(email, new BadRequestException("이메일 입력!")); // (1)
        checkRequired(password, new BadRequestException("비밀번호 입력!")); // (2)
        checkRequired(confirmPassword, new BadRequestException("비밀번호 확인!")); // (3)
        checkRequired(userName, new BadRequestException("회원명 입력!")); // (4)

        checkTrue(result, new BadRequestException("약관에 동의함")); // (5)*/

        /* 2. 이메일 중복 여부 (회원 가입 여부 체크) */
        //checkTrue(mapper.exists(email) == 0L, new BadRequestException("해당 이메일 이미 가입되어 있음"));

        /* 3. 비밀번호 자리 수 체크 (8자리 이상) */
        //checkTrue(password.length() >= 8, new BadRequestException("비밀번호 8자리 이상 입력!"));

        /* 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword) */
        /*checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호 불일치!"));
    }*/
//}