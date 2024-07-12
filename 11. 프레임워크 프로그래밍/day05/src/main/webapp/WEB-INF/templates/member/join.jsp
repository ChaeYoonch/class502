<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %> <%-- 얘가 커스텀 태그 --%>
<c:url var="actionUrl" value="/member/join" />

${requestJoin}

<h1>회원가입</h1>
<form:form method="POST" action="${actionUrl}" autocomplete="off">
    <dl>
        <dt>이메일</dt>
        <dd>
            <form:input path="email" /> <%-- <input type="text" name="email" value="${requestJoin.email}"> 와 동일 --%>
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <from:password path="password" /> <%-- <input type="password" name="password"> 와 동일 --%>
        </dd>
    </dl>
    <dl>
        <dt>비밀번호 확인</dt>
        <dd>
            <form:password path="confirmPassword" /> <%-- <input type="password" name="confirmPassword"> 와 동일 --%>
        </dd>
    </dl>
    <dl>
        <dt>회원명</dt>
        <dd>
            <form:input path="userName" /> <%-- <input type="text" name="userName" value="${requestJoin.userName}"> 와 동일 --%>
        </dd>
    </dl>
    <dl>
        <dt>약관동의</dt>
        <dd>
            <form:checkbox path="agree" value="true" label="회원가이 약관에 동의합니다." />
            <%-- <input type="checkbox" name="agree" value="true" id="agree"> <label for="agree">회원가입 약관에 동의합니다.</label> --%>
        </dd>
    </dl>
    <button type="submit">가입하기</button>
</form:form>