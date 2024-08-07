package exam01.member;

import exam01.member.dao.MemberDao;
import exam01.member.services.JoinService;
import exam01.member.validators.JoinValidator;

public class Assembler { // 객체 조립기 역할 - 내부에서 외부(다른 클래스) 부품 조립

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() { // return JoinValidator = new JoinValidator(); 분리함
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());

        return validator;
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao());
        //return new JoinService();
    }
}