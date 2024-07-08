package member.validators;

import global.validators.Validator;
import member.controllers.RequestJoin;
import member.dao.MemberDao;

public class JoinValidator implements Validator<RequestJoin> {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) { // setter 로 의존성 주입
        this.memberDao = memberDao;
    }

    @Override
    public void check(RequestJoin form) {

    }
}