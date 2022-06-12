<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ROUTE : <%=request.getAttribute("route") %></h1>
	<c:choose>
		<c:when test="${route eq 'init' }">
			<%@ include file="/WEB-INF/res/tags/resAdminHeader.tag"%>
			<form method="post" action="login.do">
			[RESInit]
				<table style="width:300;" border="1">
					<tr>
						<th width="100">ID</th>
						<td><input type="text" name="id" size='15' /></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password" size='15' /></td>
					</tr>
					<tr>
						<td colspan='2' align='right'><input type="submit"
							value="로그인" /></td>
					</tr>
				</table>
			</form>
			<form method="post" action="login.do?id=admin&password=admin">
				<input type="submit" value="자동 로그인(1)" />
			</form>
		</c:when>
		<c:when test="${route eq 'RESMember' }">
			<%@ include file="/WEB-INF/res/tags/resMemberHeader.tag"%>
			<form method="post" action="memberLogin.do">
			[RESMember]
				<table style="width:300;" border="1">
					<tr>
						<th width="100">ID</th>
						<td><input type="text" name="id" size='15' /></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password" size='15' /></td>
					</tr>
					<tr>
						<td colspan='2' align='right'><input type="submit"
							value="로그인" /></td>
					</tr>
				</table>
			</form>
			<form method="post" action="login.do?id=admin&password=admin">
				<input type="submit" value="자동 로그인(1)" />
			</form>
		</c:when>
		<c:when test="${route eq 'POMInit' }">
			<%@ include file="/WEB-INF/pom/tags/POMMemberHeader.tag"%> 
			<form method="post" action="main">
			[POMInit]
				<table style="width:300;" border="1">
					<tr>
						<th width="100">ID</th>
						<td><input type="text" name="id" size='15' /></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password" size='15' /></td>
					</tr>
					<tr>
						<td colspan='2' align='right'><input type="submit"
							value="로그인" /></td>
					</tr>
				</table>
			</form>
			<form method="post" action="main?id=admin&password=admin">
				<input type="submit" value="자동 로그인(3)" />
			</form>
		</c:when>
	</c:choose>
</body>
</html>