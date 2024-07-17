package org.choongang.member.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Table("CH_MEMBER")
public class Member {
    @Id
    // @Column("ID")
    private Long seq; // long -> Long : 지네릭 클래스 때문에

    private String email;

    @JsonIgnore
    private String password;

    private String userName;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}