package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException {

    private int status; // 응답 코드

    public CommonException(String message) { // 기본 생성자
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    } // 500 = HttpServletResponse.SC_INTERNAL_SERVER_ERROR -> 상수 형태로 넣는 것이 유리

    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }
}
