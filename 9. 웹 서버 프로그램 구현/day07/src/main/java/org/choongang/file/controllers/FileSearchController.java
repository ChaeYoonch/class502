package org.choongang.file.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/upload/*")
public class FileSearchController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().replace(req.getContextPath(), ""); // 현재 접속 주소
        // /upload/파일 경로 가 필요함!

        Pattern pattern = Pattern.compile("^/upload/(.+)"); // 1글자 이상 | . = 줄 개행 문자 제외 모든 문자 중 문자 1개 의미
        Matcher matcher = pattern.matcher(uri);
        if (matcher.find()) {
            String fileName = matcher.group(1); // (.+) 의 첫 번째 의미함

            File file = new File("D:/uploads/" + fileName);
            if (file.exists()) { // 파일이 있는 경우

                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    OutputStream out = resp.getOutputStream();
                    out.write(bis.readAllBytes());
                }
                return;
            }
        }
        // 파일이 없는 경우 -> 404 응답 코드
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}