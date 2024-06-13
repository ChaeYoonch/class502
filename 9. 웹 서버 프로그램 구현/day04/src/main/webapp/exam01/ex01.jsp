<%-- ex01.jsp 는 _jspService 안에 있는 jsp 파일이다! => 지역 안에 있기에 다른 자원 접근 가능! --%>
<%-- ex01.jsp -> ex01_jsp.java  (jsp -> 서블릿 클래스로 번역될 때 : JSP 주석 제거)
//, /* ~ */ -> ex01.jsp -> ex01_jsp.java (번역) : 포함 -> 컴파일 -> ex01_jsp.class (일반 코드 주석 //, /* ~ */ 제거)
<%@ page contentType="text/html" pageEncoding="UTF-8" %> 얘가 아래 애랑 동일한 내용
--%>
<%@ page contentType="text/html; charset=UTF-8" %>