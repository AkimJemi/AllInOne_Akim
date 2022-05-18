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
				<th>번호</th>
				<th>예약번호</th>
				<th>예약상태</th>
			</tr>
			<c:forEach var="reservation" items="${reservation }">
				<tr>
					<td>${reservation.no }</td>
					<td>${reservation.revNum }</td>
					<td>${reservation.ifreservation }</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>