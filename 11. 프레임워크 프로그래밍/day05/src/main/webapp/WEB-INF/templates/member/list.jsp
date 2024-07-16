<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>회원 목록</h1>
<form:form method="get" autocomplete="off" modelAttribute="memberSearch">
    가입일
    <form:input path="sDate" />
    <form:errors path="sDate" />
     ~
    <form:input path="eDate" />
    <form:errors path="eDate" /> <%-- 에러 코드 미 연동시에는 기본 코드 나옴 --%>
    <button type="submit">검색하기</button>
</form:form>