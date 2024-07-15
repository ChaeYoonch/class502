package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component // 자동 스캔
@RequiredArgsConstructor // 의존성 주입 : mapper
public class LoginValidator implements Validator {

    private final MemberMapper mapper; // 의존성 주입

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) { // 여기서 검증
        /**
         * 1) 필수 항목 검증 (email, password) -> 얘는 알아서 해줌 (아까 추가함)
         * 2) 이메일로 회원이 조회되는지 검증
         * 3) 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증
         */

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        /* 2. 이메일로 회원이 조회되는지 검증 */
        if (StringUtils.hasText(email)) {
            Member member = mapper.get(email); // email 가져옴
            if (member == null) {
                errors.rejectValue("email", "Fail.login");
            }
        /* 3. 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증 */
        }

        /* 1. 필수 항목 검증 (email, password) */
        /* ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required", "이메일을 입력하세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required", "비밀번호를 입력하세요."); 복습해본 것! */
    }

}