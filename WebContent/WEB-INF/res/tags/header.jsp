<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/res/tags/resShortcut.tag"%>

<style>
body {
	font-size: 23px;
}
</style>
<header>

	request.getRequestURL() :
	<%=request.getRequestURL()%>
	<br />
	request.getRequestURI() :
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
			<tr>
				<td>URI는 URL의 의미를 품고있다. URL(Uniform Resource Locator)은 자원이 실제로
					존재하는 위치를 가리키며, URI(Uniform Resource Identifier)는 자원의 위치뿐만 아니라 자원에
					대한 고유 식별자로서 URL을 의미를 포함한다.</td>
					<td>dd
					</td>
			</tr>
		</tbody>

	</table>


	<a href='<%=request.getContextPath()%>/res/admin/main.do'>메인 페이지로</a>
</header>