<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/res/tags/resAdminShortcut.tag"%>

<style>
body {
	font-size: 23px;
}
</style>
<header>

<h4>request.getRequestURI() :</h4>
	<%=request.getRequestURI()%>
	<br />
	request.getContextPath() :
	<%=request.getContextPath()%>
	<br />
	<table>
		<tbody>
			<tr>
				<td>URI</td>
				<td>URL</td>
			</tr>
			<tr>
				<td>Is a type of URI</td>
				<td>URI is the superset of URL</td>
			</tr>
			<tr>
				<td>Access the location or address of the resource</td>
				<td>Find the resource</td>
			</tr>
			<tr>
				<td>Its components are protocol, domain, path, hash, query
					string and so on</td>
				<td>Components included are scheme, authority, path, query and
					more</td>
			</tr>
			</tbody>

	</table>
	<a href='<%=request.getContextPath()%>/res/main'>메인 페이지로</a>
</header>