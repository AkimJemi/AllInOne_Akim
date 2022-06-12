<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/res/tags/resAdminHeader.tag" %>
<center><h1>jspPathError</h1></center>
key['3'] = "<%=request.getContextPath()%>/res/main";
<br/>
key['4'] = "<%=request.getContextPath()%>/res/member/main";
<br/>
key['5'] = "<%=request.getContextPath()%>/res/admin/main";
<br/>
key['6'] = "<%=request.getContextPath()%>/res/admin/book/list";
<br/>
key['7'] = "<%=request.getContextPath()%>/res/admin/member/list";
<br/>

</body>
</html>