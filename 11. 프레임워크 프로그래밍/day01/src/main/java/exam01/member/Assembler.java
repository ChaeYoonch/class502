package exam01.member;

import exam01.member.dao.MemberDao;

public class Assembler { // 객체 조립기 역할

    public MemberDao memberDao() {
        return new MemberDao();
    }
}