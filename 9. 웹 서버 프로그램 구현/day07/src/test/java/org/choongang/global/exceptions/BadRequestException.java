package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class BadRequestException extends CommonException {

    public BadRequestException() {
        this("잘못된 요청 입니다.");
    }

    public BadRequestException(String message) {
        super(message, HttpServletResponse.SC_BAD_REQUEST);
    } // 400 = HttpServletResponse.SC_BAD_REQUEST -> 상수로 설정
}
