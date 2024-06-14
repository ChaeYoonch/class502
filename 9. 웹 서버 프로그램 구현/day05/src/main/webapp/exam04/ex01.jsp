<%@ page contentType="text/html; charset=UTF-8" %>
<%
    pageContext.setAttribute("num", 10);
%>
${100 + 200}<br> <%-- 연산, 자바 코드 가능 --%>
${num == 10 ? "숫자 10 입니다.":"숫자 10이 아닙니다."} <%-- ${num == 10 ? "숫자 10 입니다.":"숫자 10이 아닙니다."} --%>