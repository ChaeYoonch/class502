<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/member/login" />
<layout:main title="로그인">
    <h1>로그인</h1>
    <form method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
        <dl>
            <dt>이메일</dt>
            <dd>
                <input type="text" name="email" value="${cookie.saveEmail == null ? '':cookie.saveEmail.value}">
            </dd> <%-- saveEmail 값이 null 이면 빈 값을 있으면 저장된 값을 나오게 함 --%>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="password">
            </dd>
        </dl>
        <div>
            <input type="checkbox" name="saveEmail" value="true" id="saveEmail" ${cookie.saveEmail == null ? '' : ' checked'}> <%-- saveEmail 값이 null 이면 빈 값을 있으면 checked 를 나오게 함 --%>
            <label for="saveEmail">이메일 기억하기</label>
        </div>
        <button type="submit">로그인</button>
    </form>
</layout:main>