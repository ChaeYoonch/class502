package exam01;

import member.Board;
import member.Member;
import org.junit.jupiter.api.Test;

public class Ex02 {
    @Test
    void test1() {
        Member member = new Member("User01", "사용자02");
        member.setEmail("USER01@");
        System.out.println(member);
    }

    @Test
    void test2() {
        Board board = new Board("제목", "내용");
        System.out.println(board);
    }
}
