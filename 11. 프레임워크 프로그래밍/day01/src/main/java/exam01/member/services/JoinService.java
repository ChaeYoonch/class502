package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.validators.JoinValidator;

public class JoinService { // 회원가입 서비스

    private JoinValidator validator;

    // 의존 관계 - 없으면 객체 생성 X | 생성자를 통한 주입 (필수!)
    public JoinService(JoinValidator validator) {
        this.validator = validator;
    }

    /* 연관 관계 -> 만들고 난 다음 의존 주입 | setter = 필수 X -> 없어도 객체는 생성됨
    public void setValidator(JoinValidator validator) {
        this.validator = validator;
    } */

    public void process(RequestJoin form) {
        validator.check(form); // JoinService 는 validator 와 form 객체 필요 (= 의존) -> 의존성

        // 데이터 영구 저장 - DAO (Data Access Object) ex. mybatis.mapper
    }
}