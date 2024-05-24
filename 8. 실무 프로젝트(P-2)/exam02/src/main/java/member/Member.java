package member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private long userNo;  // USER_NO
    private String userId; // USER_ID
    private String userPw; // USER_PW
    private String userNm; // USER_NM
    private String mobile; // MOBILE
    private LocalDateTime regDt; // REG_DT
    private LocalDateTime modDt; // MOD_DT
}
