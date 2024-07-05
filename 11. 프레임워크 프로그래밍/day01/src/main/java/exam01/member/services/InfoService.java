package exam01.member.services;

import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InfoService { // 의존성 주입 = 1) setter 2) 생성자 사용
    private MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void printList() {
        List<Member> members = memberDao.getList();
        members.forEach(System.out::println);
    }
}