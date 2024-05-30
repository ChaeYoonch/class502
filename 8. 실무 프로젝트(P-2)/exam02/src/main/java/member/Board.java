package member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Board {
    private long seq;  // USER_NO | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String poster; // USER_ID | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String subject; // USER_PW | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String content; // USER_NM | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String mobile; // MOBILE | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private LocalDateTime regDt; // REG_DT
    private LocalDateTime modDt; // MOD_DT
}