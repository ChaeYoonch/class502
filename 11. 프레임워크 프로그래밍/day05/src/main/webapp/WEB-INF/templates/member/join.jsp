<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%-- 얘가 커스텀 태그 --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%-- message tag 로 연동--%>

<c:url var="actionUrl" value="/member/join" />
<h1>
    <spring:message code="회원가입" />
</h1>
<form:form method="POST" action="${actionUrl}" autocomplete="off" modelAttribute="requestJoin">
    <dl>
        <dt>
            <spring:message code="이메일" />
        </dt>
        <dd>
            <form:input path="email" /> <%-- <input type="text" name="email" value="${requestJoin.email}"> 와 동일 --%>
            <form:errors path="email" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호" />
        </dt>
        <dd>
            <form:password path="password" /> <%-- <input type="password" name="password"> 와 동일 --%>
            <form:errors path="password" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호_확인" />
        </dt>
        <dd>
            <form:password path="confirmPassword" /> <%-- <input type="password" name="confirmPassword"> 와 동일 --%>
            <form:errors path="confirmPassword" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="회원명" />
        </dt>
        <dd>
            <form:input path="userName" /> <%-- <input type="text" name="userName" value="${requestJoin.userName}"> 와 동일 --%>
            <form:errors path="userName" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="약관_동의" />
        </dt>
        <dd>
            <form:checkbox path="agree" value="true" label="회원가입 약관에 동의합니다." />
            <%-- <input type="checkbox" name="agree" value="true" id="agree"> <label for="agree">회원가입 약관에 동의합니다.</label> --%>
            <form:errors path="agree" element="div" delimiter="" />
        </dd>
    </dl>
    <button type="submit">
        <spring:message code="가입하기" />
    </button>
</form:form>