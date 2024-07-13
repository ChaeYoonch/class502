package org.choongang.user.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt;
}