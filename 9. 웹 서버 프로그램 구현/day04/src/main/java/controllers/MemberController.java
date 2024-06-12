package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    @Override // req & resp : 객체
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // 조회
        String mode = getMode(req);
        if (mode.equals("join")) { // / 뒤가 join 일 때
            joinForm(req, resp);
        } else if (mode.equals("login")) { // / 뒤가 login 일 때
            loginForm(req, resp);
        }
    } // super 삭제 + protected -> public 범위 확장

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req);
        if (mode.equals("join")) {
            joinProcess(req, resp);
        } else if (mode.equals("login")) {
            loginProcess(req, resp);
        }
    }

    private String getMode(HttpServletRequest req) {
        String url = req.getRequestURI(); // 주소
        String[] urls = url.split("/"); // 주소를 /로 자름
        String mode = urls.length > 0 ? urls[urls.length - 1] : ""; // - 1 : 가장 끝의 문구

        return mode;
    } // 주소 끝의 문자열을 잘라오는 함수 -> doGet & doPost 모두에 같은 내용이 들어가므로 함수로 만들어 적용함

    // Get 방식일 때 사용 - 회원가입 양식
    private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>회원가입</h1>");
    } // doPost 에서 ServletException, IOException 전가시키고 있으므로 넘겨도 됨! | req : 조회, resp : 응답

    // Get 방식일 때 사용 - 로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>로그인</h1>");
    }

    // Post 방식일 때 사용 - 회원가입 처리
    private void joinProcess(HttpServletRequest req, HttpServletResponse resp) {

    }

    // Post 방식일 때 사용 - 로그인 처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse resp) {

    }
}
