package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;
import java.io.PrintWriter;

import static org.choongang.global.MessageUtil.alertError;

@WebServlet("/member/join")
public class JoinController extends HttpServlet { // 회원가입
    // 메서드 재정의
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Buffer 버퍼 치환 -> forward 사용
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp"); // 웹 경로 기준
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JoinService service = MemberServiceProvider.getInstance().joinService();
            service.process(req);

            resp.sendRedirect(req.getContextPath() + "/member/login");
        } catch (CommonException e) {
            alertError(e, resp);
        }
    }
}