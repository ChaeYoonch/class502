package org.choongang.global.rests;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONData {
    private HttpStatus status; // 성공하든 실패하든 동일한 형식
    private boolean success; // 성공, 실패 확인
    private String message; // 실패 시 메세지
    private Object data; // 성공 시 데이터 | 모든 값이 들어오므로 Object
}