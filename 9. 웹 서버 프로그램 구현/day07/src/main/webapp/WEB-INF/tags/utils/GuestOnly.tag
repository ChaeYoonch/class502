<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="org.choongang.member.MemberUtil" %>
<% if (!MemberUtil.isLogin(request)) { %>
<jsp:doBody />
<% } %> <%-- 비로그인 상태일 때만 나옴 --%>