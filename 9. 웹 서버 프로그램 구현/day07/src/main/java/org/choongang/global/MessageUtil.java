package org.choongang.global;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil { // 정적 메서드 정의
    public static void alertError(Exception e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        if (e instanceof CommonException commonException) { // () 안 마지막에 commonException 넣어도 됨
            // CommonException commonException = (CommonException)e; -> 어차피 형변환 할 테니,
            resp.setStatus(commonException.getStatus());
        }
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
    } // e 와 resp 만 사용하면 됨!

    public static void go(String url, String target, HttpServletResponse resp) throws IOException {
        target = target == null || target.isBlank() ? "self" : target; // null 이거나 빈 값이면 self 로 고정 아니면 target

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>%s.location.href='%s';</script>", target, url); // url 은 '%s' 에 target 은 <script> 태그 안에
    }

    public static void go(String url, HttpServletResponse resp) throws IOException {
        go(url, "self", resp); // "self" 가 기본값 | self 대신 null 넣어도 위의 조건에서는 self 값이 나옴
    }
}