<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:bundle basename="messages.commons">
    <form>
        <fmt:message key="EMAIL" /> <%-- 메세지 코드로 관리 가능 --%>
        <input type="text" name="email"> <br>

        <fmt:message key="PASSWORD" />
        <input type="text" name="password"> <br>
        <button type="submit">
            <fmt:message key="LOGIN" />
        </button>
    </form>
</fmt:bundle>