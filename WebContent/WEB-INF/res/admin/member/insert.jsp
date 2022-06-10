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
	<%@ include file="/WEB-INF/res/tags/header.jsp"%>
	<%
	String readonly = "";
	String disabled = "";
	%>
	<c:if test="${readonly }">
		<script type="text/javascript">
			alert("추가 성공");
		<%readonly = "readonly";
disabled = "disabled";%>
			
		</script>
	</c:if>
	<c:if test="${error }">
		<script type="text/javascript">
			alert("추가 실패");
		</script>
	</c:if>
	<form action="insert" method="POST">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${member.id }"
					<%= readonly%> /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password"
					value="${member.password }" <%= readonly%> /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${member.name }"
					<%= readonly%> /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email" value="${member.email }"
					<%= readonly%> /></td>
			</tr>
			<tr>
				<td>gender</td>
				<td>
					<%
					String genderM = "";
					String genderF = "";
					%> <c:if test="${member.gender eq 'M' }">
						<%
						genderM = "selected";
						%>
					</c:if> <c:if test="${member.gender eq 'F' }">
						<%
						genderF = "selected";
						%>
					</c:if> <select name="gender" <%=disabled%>>
						<option value="none">gender</option>
						<option value="M" <%=genderM%>>Male</option>
						<option value="F" <%=genderF%>>Female</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>age</td>
				<td><input type="number" name="age" value="${member.age }"
					<%= readonly%> /></td>
			</tr>
		</table>
		<c:choose>
			<c:when test="${readonly }">
				<input type="button" onclick="location.href='list'" value="back" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="submit" />
				<input type="button" onclick="location.href='list'" value="back" />
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>