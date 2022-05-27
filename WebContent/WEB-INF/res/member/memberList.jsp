<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="insert">
		<script type="text/javascript">
			alert("예약 성공");
		</script>
	</c:if>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>ID</th>
			<th>Password</th>
			<th>성별</th>
			<th>이메일</th>
			<th>나이</th>
			<th>예약</th>
		</tr>
		<c:forEach var="member" items="${member}">
			<tr>
				<td>${member.no }</td>
				<td>${member.name}</td>
				<td>${member.id}</td>
				<td>${member.password}</td>
				<td>${member.gender}</td>
				<td>${member.email}</td>
				<td>${member.age}</td>
				<td>
					<input type="button" onClick="location.href='../book/insert.do?no=${member.no}'" value="예약" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onClick="location.href='../main.do'" value="돌아가기" />
</body>
</html>