<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="res.admin.book.model.Book"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty insertResult}">
		<script type="text/javascript">
			alert('${insertResult}');
		</script>
	</c:if>
	<%@ include file="/WEB-INF/res/tags/header.jsp"%>
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
				<td><a href="res/admin/member/detail.do?no=${member.no }">${member.no }</a></td>
				<td>${member.name}</td>
				<td>${member.id}</td>
				<td>${member.password}</td>
				<td>${member.gender}</td>
				<td>${member.email}</td>
				<td>${member.age}</td>
				<td><input type="button"
					style="background-color: blue; color: white;"
					onClick="location.href='../book/insert.do?no=${member.no}'"
					value="예약" /></td>
			</tr>
		</c:forEach>

		<%
		int max = ((ArrayList<Book>) request.getAttribute("book")).size();
		
		for (int i = 1; i < max; i++) {
		%>
		<a><%=max %></a>

		<%
		}
		%>
		<c:forEach var="book" items="${book}">
			<tr>
				<td><a href="res/admin/book/detail.do?no=${book.no }">${book.no }</a></td>
				<td>${book.res_nvm}</td>
				<td>${book.if_res}</td>
				<td>${book.check_res}</td>
				<%-- <td><input type="button"
					onClick="location.href='../book/insert.do?no=${book.no}'"
					value="예약" /></td> --%>
			</tr>
		</c:forEach>

	</table>
</body>
</html>