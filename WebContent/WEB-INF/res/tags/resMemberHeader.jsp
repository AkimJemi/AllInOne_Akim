<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<style>
body {
	font-size: 23px;
}
</style>
<%@ include file="/WEB-INF/res/tags/resMemberShortcut.tag"%>
<header>
	<h4>request.getRequestURI() :</h4>
	<%=request.getRequestURI()%>
	<br />
	request.getContextPath() :
	<%=request.getContextPath()%>
	<br />
	<a href='<%=request.getContextPath()%>/res/member/main'>메인 페이지로</a>
</header>