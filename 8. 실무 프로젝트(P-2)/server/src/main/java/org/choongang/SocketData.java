package org.choongang;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // 매개변수가 없는 기본 생성자
@AllArgsConstructor // 매개변수가 있는 생성자
public class SocketData { // 매개변수가 있는 생성자 -> 초기화 O
    private String from; // 보내는 쪽
    private String to; // 받는 쪽
    private String message; // 메세지
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // json 형태일 때 날짜 형태 변경 가능
    private LocalDateTime regDt;
}