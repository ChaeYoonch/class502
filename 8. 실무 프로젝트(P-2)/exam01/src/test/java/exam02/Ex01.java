package exam02;

import configs.DBConn;
import org.junit.jupiter.api.Test;

public class Ex01 {

    @Test
    void test1() {
        SqlSession session = DBConn.getSession();
        List<Member> members = session.selectList("mappers.MemberMapper.getList");
        members.forEach(System.out::println);
    }
}
