package member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private long userNo;  // USER_NO | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String userId; // USER_ID | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String userPw; // USER_PW | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String userNm; // USER_NM | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private String mobile; // MOBILE | 변수명 = MemberMapper.xml 의 #에 들어가는 내용
    private LocalDateTime regDt; // REG_DT
    private LocalDateTime modDt; // MOD_DT
}
