package member.validators;

import global.validators.RequiredValidator;
import global.validators.Validator;
import member.controllers.RequestJoin;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {

    @Override
    public void check(RequestJoin form) {
        /**
         * 1. 필수 항목 검증 (email, password, confirmPassword, userName, agree)
         * 2. 이메일 중복 여부 (회원이 가입되어 있는지 체크)
         * 3. 비밀번호 자리 수 체크 (8자리 이상)
         * 4. 비밀번호, 비밀번호 확인 일치 여부 (password, confirmPassword)
         */

        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean result = form.isAgree();
    }
}