package member.services;

import global.Mailer;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginService {
    private Validator<HttpServletRequest> validator;
    private Mailer mailer; // 로그인이 성공하면 메일 전송

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator;
    }

    public void setMailer(Mailer mailer) {
        this.mailer = mailer;
    }

    public void process(HttpServletRequest request) {
        validator.check(request);

        // 로그인 성공 가정
        // 성공 시 메일 전송
        if (mailer != null) {
            String email = request.getParameter("email");
            mailer.send(email);
        } // 실제 메일이 보내졌는지는 should 를 사용하여 알 수 있음 -> Ex02Test 에서 should 사용
    }
}
