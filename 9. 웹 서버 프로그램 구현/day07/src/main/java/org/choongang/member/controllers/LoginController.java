package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/login")
public class LoginController extends HttpServlet { // 로그인

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Buffer 버퍼 치환 -> forward
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp"); // 웹 경로 기준
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            LoginService service = MemberServiceProvider.getInstance().loginService();
            service.process(req);

            /* 이메일 기억하기 처리 S */
            String email = req.getParameter("email");
            Cookie cookie = new Cookie("saveEmail", email);
            if (req.getParameter("saveEmail") != null) { // 이메일 기억하기 체크
                // 7일간 쿠키 기억하기
                cookie.setMaxAge(60 * 60 * 24 * 7);
            }  else { // 체크 해제 - 쿠키 제거
                cookie.setMaxAge(0);
            }
            resp.addCookie(cookie); // cookie 응답 헤더에 연결 | 체크하면 null 값 O , 체크하지 않으면 null 값 X
            /* 이메일 기억하기 처리 E */

            go(req.getContextPath() + "/", "parent", resp);
        } catch (CommonException e) {
            alertError(e, resp);
        }
    }
}