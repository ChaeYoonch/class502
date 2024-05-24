package exam01;

import configs.DBConn;
import mappers.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import member.Member;

import java.util.List;

public class Ex01 {

    @Test
    void test1() {
        SqlSession session = DBConn.getSession(); // 얘로 쿼리 구문 실행 | namespace.Id 로 작성 | namespace & Id로 접근
        List<Member> members = session.selectList("mappers.MemberMapper.getList");
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        SqlSession session = DBConn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        List<Member> members = mapper.getList(); // 메서드 정의 -> 구현체 생성
        members.forEach(System.out::println);
    }

    @Test
    void test3() {
        SqlSession session = DBConn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class); // 인터페이스의 구현체를 내부에서 프록시 형태로 변경
        List<Member> members = mapper.getList2(); // 인터페이스에 애노테이션으로 바로 정의함
        members.forEach(System.out::println);
    }
}
