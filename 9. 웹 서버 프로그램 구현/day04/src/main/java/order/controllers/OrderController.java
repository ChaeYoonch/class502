package order.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서비스 처리 ...
        req.setAttribute("message", "처리완료"); // servlet 을 통해야만 처리 결과 도출됨 -> 결과에 의존하고 있음

        // 출력 처리 (View 역할 분담)
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/order/order.jsp");
        rd.forward(req, resp); // webapp 이 기준 경로 (order 앞의 / 의미) "/order/order.jsp"
    }
}
