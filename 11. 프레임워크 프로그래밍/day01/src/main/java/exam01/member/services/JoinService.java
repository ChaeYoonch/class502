package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;

public class JoinService { // 회원가입 서비스

    @Autowired
    private JoinValidator validator;

    @Autowired
    @Qualifier("memberDao")
    private MemberDao memberDao; // 기능을 수행하기 위해 필요한 객체

    // 의존 관계 - 없으면 객체 생성 X | 생성자를 통한 주입 (필수!)
    /*public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }*/

    /* 연관 관계 -> 만들고 난 다음 의존 주입 | setter = 필수 X -> 없어도 객체는 생성됨
    public void setValidator(JoinValidator validator) {
        this.validator = validator;
    } */

    public void process(RequestJoin form) {
        validator.check(form); // JoinService 는 validator 와 form 객체 필요 (= 의존) -> 의존성

        // 데이터 영구 저장 - DAO (Data Access Object) ex. mybatis.mapper
        Member member = Member.builder()
                        .email(form.getEmail())
                        .password(form.getPassword())
                        .userName(form.getUserName())
                        .regDt(LocalDateTime.now())
                        .build();

        memberDao.register(member);
    }
}