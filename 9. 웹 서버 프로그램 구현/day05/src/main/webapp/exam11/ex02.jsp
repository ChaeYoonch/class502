<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie[] cookies = request.getCookies(); // 전체 조회
    for (Cookie cookie : cookies) {
        String name = cookie.getName(); // 이름 조회
        String value = cookie.getValue(); // 값 확인

        System.out.printf("name=%s, value=%s\n", name, value); // 콘솔에 출력
    } // 향상된 for 문
%>