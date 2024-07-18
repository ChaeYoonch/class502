package org.choongang.global.rests;

import lombok.Data;

@Data
public class JSONData {
    private boolean success; // 성공, 실패 확인
    private String message; // 실패 시 메세지
}