<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="actionUrl" value="/member/join" />
<h1>회원가입</h1>
<form method="POST" action="${actionUrl}" autocomplete="off">
    <dl>
        <dt>이메일</dt>
        <dd>
            <input type="text" name="email">
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <input type="password" name="password">
        </dd>
    </dl>
    <dl>
        <dt>비밀번호 확인</dt>
        <dd>
            <input type="password" name="confirmPassword">
        </dd>
    </dl>
    <dl>
        <dt>회원명</dt>
        <dd>
            <input type="text" name="userName">
        </dd>
    </dl>
</form>