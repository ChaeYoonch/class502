package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
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

        // Bean Validation 검증 실패 시에는 다음 검증을 진행하지 않음 !!
        if (errors.hasErrors()) {
            return; // null 방지
        }
        /**
         * 1) 필수 항목 검증 (email, password) -> 얘는 알아서 해줌 (아까 추가함)
         * 2) 이메일로 회원이 조회되는지 검증
         * 3) 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증
         */

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword(); // 사용자가 입력한 비밀번호

        /* 2. 이메일로 회원이 조회되는지 검증 */
        if (StringUtils.hasText(email)) { // email 값이 있을 때
            Member member = mapper.get(email); // email 가져옴
            if (member == null) {
                // errors.rejectValue("email", "Check.emailPassword");
                errors.reject("Check.emailPassword"); // 얘네는 global error 로 reject = field 가 없음 (필드 한정 X), 에러를 자세히 명시하지 않음
            }

        /* 3. 조회된 회원의 비밀번호가 입력한 값과 일치하는지 검증 */
            if (member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password, member.getPassword())) { // password 값이 있을 때
                // errors.rejectValue("password", "CheckemailPassword");
                errors.reject("Check.emailPassword"); // 얘네는 global error 로 reject = field 가 없음 (필드 한정 X), 에러를 자세히 명시하지 않음
            }
        }
    }
}