<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/res/tags/shortcut.tag"%>
</head>
<body>
	<div><%=request.getParameter("error")%></div>
		<form method="post" action="login.do">
			<table width='300' border="1">
				<tr>
					<th width="100">ID</th>
					<td>
						<input type="text" name="id" size='15' />
					</td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td>
						<input type="password" name="password" size='15' />
					</td>
				</tr>
				<tr>
					<td colspan='2' align='right'>
						<input type="submit" value="로그인" />
					</td>
				</tr>
			</table>
		</form>
		<form method="post" action="login.do?id=admin&password=admin">
			<input type="submit" value="자동 로그인(1)" />
		</form>
</body>
</html>