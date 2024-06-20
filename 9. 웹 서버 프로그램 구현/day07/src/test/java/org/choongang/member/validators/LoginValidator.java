package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator { // 로그인 서비스 구성

    @Override
    public void check(HttpServletRequest form) {

    }
}