<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h1>게시글 목록</h1>
<ul>

<c:forEach var="item" items="${items}" varStatus="status"> // 현재 current 는 var="item" 의 item 이다!
    <li>
        ${item.subject} / ${item.content} / ${item.poster} / ${item.regDt}
        <div>
            index: ${status.index} / count: ${status.count} / first: ${status.first} / last: ${status.last} / current: ${status.current}
        </div>
    </li>
</c:forEach>

</ul>