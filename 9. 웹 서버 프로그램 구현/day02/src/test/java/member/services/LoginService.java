package member.services;

import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginService {
    // private LoginValidator validator = new LoginValidator();
    private Validator<HttpServletRequest> validator;

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator;
    }
    public void process(HttpServletRequest request) {
        validator.check(request);
    }
}
