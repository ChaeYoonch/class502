package mappers;

import member.Member;

import java.util.List;

public interface MemberMapper { // xml 와 동일한 명칭의 interface -> namespace 굳이 명시하지 않아도 가능
    List<Member> getList();
}
