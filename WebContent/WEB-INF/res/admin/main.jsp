<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/css/commonCss.jsp"%>
<style type="text/css">
table {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/res/tags/resAdminHeader.jsp" %>
	<div class="center">시작</div>
	<table border='1'>
		<tr>
			<td>메인 페이지</td>
		</tr>
		<tr>
			<th><a href="book/list">관리자 페이지(6)</a></th>
			<th><a href="member/list">회원 명단(7)</a></th>
		</tr>
		<tr>
		</tr>
	</table>
</body>
</html>