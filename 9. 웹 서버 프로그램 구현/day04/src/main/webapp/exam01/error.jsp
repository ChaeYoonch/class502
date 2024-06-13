<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %> <%-- 에러 페이지 발생 시 정보 알려줌 --%>
<h1>에러 발생!!</h1>
<%=exception.getMessage()%>
<%
    exception.printStackTrace();
%>