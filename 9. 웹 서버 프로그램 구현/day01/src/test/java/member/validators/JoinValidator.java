package member.validators;

import global.exceptions.ValidationException;
import global.validators.RequiredValidator;
import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator { // 검증에 대한 부분은 여기서만 정의함

    @Override
    public void check(RequestJoin form) {
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();

        /* 필수 항목 검증 S */
        checkRequired(email, new ValidationException("이메일을 입력하세요."));
        checkRequired(password, new ValidationException("비밀번호를 입력하세요."));
        checkRequired(confirmPassword, new ValidationException("비밀번호를 확인하세요."));
        checkRequired(userName, new ValidationException("회원명을 입력하세요."));
        /* if (email == null || email.isBlank()) { // email 이 null 이거나 공백인 경우
            throw new ValidationException("이메일을 입력하세요.");
        }

        if (password == null || password.isBlank()) { // password 가 null 이거나 공백인 경우
            throw new ValidationException("비밀번호를 입력하세요.");
        }

        if (confirmPassword == null || confirmPassword.isBlank()) { // confirmPassword 가 null 이거나 공백인 경우
            throw new ValidationException("비밀번호를 확인하세요.");
        }

        if (userName == null || userName.isBlank()) { // userName 가 null 이거나 공백인 경우
            throw new ValidationException("사용자명을 입력하세요.");
        } */
        /* 필수 항목 검증 E */
    }
}
