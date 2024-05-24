package mappers;

import member.Member;

import java.util.List;

public interface MemberMapper { // MemberMapper.xml 와 동일한 명칭의 interface -> 알아서 패턴 생성 -> 굳이 명시하지 않아도 가능
    List<Member> getList(); // MemberMapper.xml 의 <select id="getList"> Id 값을 메서드로 사용
}
