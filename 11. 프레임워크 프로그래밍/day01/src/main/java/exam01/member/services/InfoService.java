package exam01.member.services;

import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class InfoService { // 의존성 주입 = 1) setter 2) 생성자 사용
    private MemberDao memberDao;

    private DateTimeFormatter formatter;

    @Autowired
    @Qualifier("mDao") // 빈의 이름 직접 지정
    public void setMemberDao(Optional<MemberDao> opt) { // public void setMemberDao(MemberDao memberDao) | this.memberDao = memberDao
        this.memberDao = opt.get();
    }

    @Autowired
    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public void printList() {
        List<Member> members = memberDao.getList();
        members.forEach(m -> {
            System.out.println(m);
            LocalDateTime regDt = m.getRegDt();
            System.out.println(formatter.format(regDt));
        });
    }
}