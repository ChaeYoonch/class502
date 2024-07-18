package org.choongang.global.rests;

import lombok.Data;

@Data
public class JSONData {
    private boolean success; // 성공, 실패 확인
    private String message; // 실패 시 메세지
    private Object data; // 성공 시 데이터 | 모든 값이 들어오므로 Object
}