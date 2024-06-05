package member.services;

import global.validators.Validator;
import member.controllers.RequestJoin;

public class JoinService {

    private Validator<RequestJoin> validator; // 구성 부품 형태로 내부에서 정의

    public JoinService(Validator<RequestJoin> validator) {
        this.validator = validator;
    } // private JoinValidator validator = new JoinValidator(); -> 의존 역전 원칙으로 변경한 것

    public void process(RequestJoin form) {

        validator.check(form);
    }
}
