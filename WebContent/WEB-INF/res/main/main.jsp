<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<%@ include file="/WEB-INF/res/tags/shortcut.tag"%>
</head>
<body>
	<table border='1'>
		<tr>메인 페이지
		</tr>
		<tr>
			<th><a href="admin.do">관리자 페이지(2)</a></th>
			<th><a href="member/list.do">회원 명단(3)</a></th>
		</tr>
		<tr>
		</tr>
	</table>
</body>
</html>