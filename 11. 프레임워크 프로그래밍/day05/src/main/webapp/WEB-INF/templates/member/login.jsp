<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="actionUrl" value="/member/login" />

<h1>
    <spring:message code="로그인" />
</h1>

<form:form method="post" action="${actionUrl}" autocomplete="off" modelAttribute="requestLogin"> <%-- 기본값이 커맨드 라는 명시 : modelAttribute="requestLogin"--%>
    <dl>
        <dt>
            <spring:message code="이메일" />
        </dt>
        <dd>
            <form:input path="email" />
            <form:errors path="email" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호" />
        </dt>
        <dd>
            <form:input path="password" />
            <form:errors path="password" />
        </dd>
    </dl>
</form:form>