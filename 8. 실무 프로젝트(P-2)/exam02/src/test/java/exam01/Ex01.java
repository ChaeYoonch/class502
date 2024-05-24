package exam01;

import configs.DBConn;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import member.Member;

import java.util.List;

public class Ex01 {

    @Test
    void test1() {
        SqlSession session = DBConn.getSession(); // 얘로 쿼리 구문 실행 | namespace.Id 로 작성
        List<Member> members = session.selectList("mappers.MemberMapper.getList");
        members.forEach(System.out::println);
    }
}
