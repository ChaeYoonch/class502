package exam01;

import member.Board;
import member.Member;
import member.User;
import member.User2;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    void test3() {
        /* User user = new User; 생성자가 private 로 정해져서 만들 수 없음 */
        User user = User.builder()
                .userId("USER01")
                .userNm("사용자01")
                .email("USER01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        System.out.println(user);
    }

    @Test
    void test4() {
        /* User2 user = new User2; 생성 불가! */
        User2 user = User2.builder()
                .userId("USER01")
                .userNm("사용자01")
                .email("USER01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        System.out.println(user);

        User2 user2 = new User2();
    }
}
