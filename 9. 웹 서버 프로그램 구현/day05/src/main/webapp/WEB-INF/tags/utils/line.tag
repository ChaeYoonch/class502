<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="color" %> <%-- 내부 지역변수 생성 / EL식 속성 추가 --%>
<%@ attribute name="size" type="java.lang.Integer" required="true" %>
<%--
<%=color%>
${color} --%>
<div style="color: ${color};">
<%
    for (int i = 0; i < size; i++) {
        out.write("-");
    }
%>
</div>