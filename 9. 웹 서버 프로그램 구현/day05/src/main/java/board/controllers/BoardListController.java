package board.controllers;

import board.entities.BoardData;
import board.services.BoardInfoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list/*")
public class BoardListController extends HttpServlet { // 애는 Controller
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardInfoService service = new BoardInfoService(); // 뷰가 직접 jsp 파일 접근하지 못하도록
        List<BoardData> items = service.getList();

        req.setAttribute("items", items);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list.jsp"); // 얘가 View
        rd.forward(req, resp);
    }
}