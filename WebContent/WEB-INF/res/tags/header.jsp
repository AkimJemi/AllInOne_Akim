<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/res/tags/resShortcut.tag"%>

<style>
body {
	font-size: 23px;
}
</style>
<header>
	<%=request.getRequestURL()%>
	<br />
	request.getContextPath() :
	<%=request.getContextPath()%>
	<br />
	<a href='<%=request.getContextPath()%>/res/admin/main.do'>메인 페이지로</a>
</header>