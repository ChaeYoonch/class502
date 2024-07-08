package member.validators;

import global.validators.Validator;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<RequestJoin> {

    private MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) { // setter 로 의존성 주입
        this.memberDao = memberDao;
    }

    @Override
    public void check(RequestJoin form) {

    }
}