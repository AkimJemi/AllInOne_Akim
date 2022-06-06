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
	<table>
		<tr>
			<td>id</td>
			<td><input type="text" name="id" value="${member.id }" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input type="text" name="password"
				value="${member.password }" /></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name" value="${member.name }" /></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="email" name="email" value="${member.email }" /></td>
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
				</c:if> <select>
					<option value="none">gender</option>
					<option value="M" <%=genderM%>>Male</option>
					<option value="F" <%=genderF%>>Female</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>age</td>
			<td><input type="number" name="age" value="${member.age }" /></td>
		</tr>


	</table>

</body>
</html>