<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<table>
			${loginedUser.id }님 환영합니다
			<tr>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="user" items="${user }">
				<tr>
					<td>${user.no }</td>
					<td>${user.id }</td>
					<td>${user.name }</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>