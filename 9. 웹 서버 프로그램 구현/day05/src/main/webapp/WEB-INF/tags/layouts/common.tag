<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="header" fragment="true" %> <%-- fragmemt="true" => 치환할 수 있는 영역 O --%>
<%@ attribute name="footer" fragment="true" %> <%-- fragmemt="true" => 치환할 수 있는 영역 O --%>
<c:url var="cssUrl" value="/static/css/" />
<c:url var="jsUrl" value="/static/js" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>레이아웃 연습!</title>
    <link rel="stylesheet" type="text/css" href="${cssUrl}style.css">
    <c:if test="${addCss != null}">
        <c:forEach var="cssFile" items="${addCss}">
            <link rel="stylesheet" type="text/css" href="${cssUrl}${cssFile}" />
        </c:forEach>
    </c:if>
    <script src="${jsUrl}common.js"></script>
    <c:if test="${addScript != null}"> <%-- 즉, 값이 있을 때 --%>
        <c:forEach var="jsFile" items="${addScript}">
            <script src="${jsUrl}${jsFile}"></script>
        </c:forEach>
    </c:if>
</head>
<body>
<header>
    <jsp:invoke fragment="header" />
</header>
<main>
    <jsp:doBody /> <%-- doBody => 태그 안 쪽의 내용물로 바뀜 --%>
</main>
<footer>
    <jsp:invoke fragment="footer" />
</footer>
</body>
</html>