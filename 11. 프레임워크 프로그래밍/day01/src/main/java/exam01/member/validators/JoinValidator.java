package exam01.member.validators;

import exam01.global.validators.Validator;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;

public class JoinValidator implements Validator<RequestJoin> {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) { // setter 로 의존성 주입
        this.memberDao = memberDao;
    }

    @Override
    public void check(RequestJoin form) {

    }
}