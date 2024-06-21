package org.choongang.file.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.file.Files;

@WebServlet("/file/download")
public class FileDownLoadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:/uploads/6.png");
        String contentType = Files.probeContentType(file.toPath());
        // 윈도우즈에서 한글 깨짐 문제 발생, 인코딩 UTF-8 -> CPC949, EUC-KR, ISO-8859_1
        String  fileName = new String(file.getName().getBytes("ISO8859_1"));

        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName); // 출력 방향 설정
        resp.setContentType(contentType); // 파일 형식 설정
        resp.setHeader("Cache-Control", "must-revalidate"); // 캐시 갱신 (파일 변경 시 내용도 바뀐 것으로 다운되도록)
        resp.setIntHeader("Expires", 0); // 만료 시간 (파일 다운로드 시 중단되지 않도록) X
        resp.setContentLengthLong(file.length()); // 전체 파일 크기

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            OutputStream out = resp.getOutputStream();
            out.write(bis.readAllBytes());
        }
    }
}