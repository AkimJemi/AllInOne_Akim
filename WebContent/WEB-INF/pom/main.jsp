<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="pom.personnel.model.Personnel"%>
<%@ page import="pom.user.model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pom.main.model.WorkExperience"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
body {
	display: flex;
	justify-content: center;
	font-family: 'Open Sans', sans-serif;
}

form {
	width: 50%;
	display: inline-block;
	margin-top: 50px;
	margin: 0 20px;
	height: 800px;
}

table {
	width: 100%;
	height: 100%;
	border: none;
}

tbody {
	width: 100%;
	height: 100%;
}

.left_box_tr1 {
	height: 10%;
}

.left_box_tr2 {
	height: 20%;
}

.left_box_tr3 {
	height: 60%;
}

.left_box_tr4 {
	height: 10%;
}

td {
	border: none;
	color: #8C8C8C;
	text-align: center;
	height: 35px;
	padding: 0;
}

select {
	font-size: 15px;
}

.td_title {
	color: #747474;
	text-align: center;
	height: 35px;
	font-weight: bold;
	border-bottom: 1px solid gray;
}

.no_a {
	color: #8C8C8C;
}

.no_a:hover {
	text-decoration-line: none;
}

.head_text {
	font-weight: bold;
	font-size: 25px;
	border-bottom: 2px solid gray;
	color: black;
	text-align: left;
}

#tr_page_a {
	padding-top: 15px;
}

.page_a {
	margin: 0 10px;
	text-decoration-line: none;
	color: #8C8C8C;
}

.page_a:hover {
	margin: 0 10px;
	text-decoration-line: none;
	color: #5d5d5d;
}

#btn_div {
	float: right;
	margin-top: 30px;
}

.input_btn {
	background-color: #353535;
	color: #EAEAEA;
	padding: auto 30px;
	margin: 10px;
	border-radius: 2px;
	border: none;
}

.input_btn:hover {
	background-color: #8C8C8C;
	color: #EAEAEA;
}

.submit_btn {
	background-color: #353535;
	color: #EAEAEA;
	padding: auto 30px;
	border-radius: 2px;
	border: none;
	width: 100px;
	height: 30px;
	font-size: 15px;
	font-weight: 400;
}

.submit_btn:hover {
	background-color: #8C8C8C;
	color: #EAEAEA;
}

.td_title {
	color: #747474;
	text-align: center;
	height: 35px;
	font-weight: bold;
	border-bottom: 1px solid gray;
}

#forEEE {
	display: inline-block;
}
</style>

<c:if test="${modify1 }">
	<script>
		$(document)
				.ready(
						function() {
							var max_Licfields = 5;
							var cr = ${licenseList.size()};
							var k = ${licenseList.size()}+1;
							$("#lic_addBtn")
									.click(
											function() {
												if (k <= max_Licfields) {
													cr++;
													k++;
													$("#forLic")
															.before(
																			'<tr class="div_lic-'+ cr +'">'
																					+ '	<td colspan="4">資格</td>'
																					+ '<td colspan="4">'
																					+ '<input type="text" name="license'+cr+'" value="" required >'
																					+ '</td>'
																					+ '	<td colspan="4">資格取得日</td>'
																					+ '	<td colspan="4">'
																					+ '	<input type="date" name="license_day'+cr+'" value="" required >'
																					+ '</td >'
																					+ '<td colspan="0"><input type="hidden" name="lic_no'+cr+'" value="'+cr+'" /></td>'
																					+ '</tr>')
												}
											})
							$("#lic_delBtn").click(function() {
								$('tr').remove('.div_lic-' + cr + '');
								if (cr != 0) {
									cr--;
								}
								if (k != 1) {
									k--;
								}
							})
						});
		function disabledCheck(ee) {
			const eb = $(ee).closest('form').get(0);
			const a = eb.disabled.value;
			if (a == 'N') {
				$(eb.disabled_grade).attr("disabled", true);
				$(eb.disabled_day).attr("disabled", true);
			} else {
				$(eb.disabled_grade).attr("disabled", false);
				$(eb.disabled_day).attr("disabled", false);
			}
		}
	</script>
</c:if>
<c:if test="${modify}">
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var max_fields = 5;
							var wr = ${workexperience.size()};
							var i = ${workexperience.size()}+1;
							$("#WE_addBtn")
									.click(
											function() {
												if (i <= 5) {
													wr++;
													i++;
													console.log("wr : " + wr);
													console.log("i : " + i);
													$("#forWE")
															.before(
																	'<tr class="div_we-'+wr+'" >'
																			+ '<td>業務履歴_官庁['
																			+ wr
																			+ ']</td>'
																			+ '<td><select name="mini_no'+wr+'">'
																			+ '<option value="10" >경영처</option>'
																			+ '<option value="20" >회계처</option>'
																			+ '<option value="30" >무역처</option>'
																			+ '<option value="40" >개발처</option>'
																			+ '<option value="50" >국내영업처</option>'
																			+ '<option value="60" >국외영업처</option>'
																			+ '<option value="70" >인사관리처</option>'
																			+ '<option value="80" >법무처</option>'
																			+ '</select></td></tr>'
																			+ '<tr class="div_we-'+ wr+ '" >'
																			+ '<td>業務履歴_部署['
																			+ wr
																			+ ']</td>'
																			+ '<td><select name="dept_no' + wr + '" >'
																			+ '<option value="10" >경영부</option>'
																			+ '<option value="20" >회계부</option>'
																			+ '<option value="30" >무역부</option>'
																			+ '<option value="40" >개발부</option>'
																			+ '<option value="50" >국내영업부</option>'
																			+ '<option value="60" >국외영업부</option>'
																			+ '<option value="70" >인사관리부</option>'
																			+ '<option value="80" >법무부</option>'
																			+ '</select></td></tr>'
																			+ '<tr class="div_we-'+wr+'">'
																			+ '<td>期間['
																			+ wr
																			+ ']</td>'
																			+ '<td><input type="date" name="begin_date'+wr+'" required />-<input type="date" name="end_date'+wr+'" required /></td><input type="hidden" name="we_no'+wr+'" value="'+wr+'"></tr>'
																			+ '')
												}
											})
							$("#WE_delBtn").click(function() {
								$('tr').remove('.div_we-' + wr + '');
								if (wr != 0) {
									wr--;
								}
								if (i != 1) {
									i--;
								}
							})

							var max_Edufields = 5;
							var er = ${eduList.size()};
							var j = ${eduList.size()}+1;
							$("#Edu_addBtn")
									.click(
											function() {
												if (j <= max_Edufields) {
													er++;
													j++;
													$("#forEdu")
															.before(
																	'<tr class="div_5-'+er + '">'
																			+ '<td>教育履歴['
																			+ er
																			+ ']</td>'
																			+ '<td><input type="text" name="edu_content'+er + '" required /></td>'
																			+ '<input type="hidden" name="edu_no'+er + '" value="'+er + '"  /> </tr>')
												}
											})
							$("#Edu_delBtn").click(function() {
								$('tr').remove('.div_5-' + er + '');
								if (er != 0) {
									er--;
								}
								if (j != 1) {
									j--;
								}
							})
						});
	</script>
</c:if>
</head>
<body>
	<%
	String a = "readonly";
	String b = "type='hidden'";
	String c = "readonly";
	String gender_M = null;
	String gender_F = null;
	String mini_a = "", mini_b = "", mini_c = "", mini_d = "", mini_e = "", mini_f = "", mini_g = "", mini_h = "";
	String dept_a = "", dept_b = "", dept_c = "", dept_d = "", dept_e = "", dept_f = "", dept_g = "", dept_h = "";
	Personnel personnel = (Personnel) request.getAttribute("personnel");
	User user = (User) request.getAttribute("user");
	ArrayList<WorkExperience> workExperiences = (ArrayList<WorkExperience>) request.getAttribute("workexperience");

	int search = 0;
	String searchField = "";
	if (request.getAttribute("search") != null) {
		search = (int) request.getAttribute("search");
		searchField = (String) request.getAttribute("searchField");
	}
	String search_a = "", search_b = "", search_c = "", search_d = "", search_e = "";
	if (search == 0)
		search_a = "selected";
	if (search == 1)
		search_b = "selected";
	if (search == 2)
		search_c = "selected";
	if (search == 3)
		search_d = "selected";
	if (search == 4)
		search_e = "selected";
	%>
	<c:if test="${modify}">
		<%
		a = "required";
		b = "type='button'";
		c = "";

		if (personnel.getMini_no() == 10) {
			mini_a = "selected";
		}
		if (personnel.getMini_no() == 20) {
			mini_b = "selected";
		}
		if (personnel.getMini_no() == 30) {
			mini_c = "selected";
		}
		if (personnel.getMini_no() == 40) {
			mini_d = "selected";
		}
		if (personnel.getMini_no() == 50) {
			mini_e = "selected";
		}
		if (personnel.getMini_no() == 60) {
			mini_f = "selected";
		}
		if (personnel.getMini_no() == 70) {
			mini_g = "selected";
		}
		if (personnel.getMini_no() == 80) {
			mini_h = "selected";
		}

		if (personnel.getDept_no() == 10) {
			dept_a = "selected";
		}
		if (personnel.getDept_no() == 20) {
			dept_b = "selected";
		}
		if (personnel.getDept_no() == 30) {
			dept_c = "selected";
		}
		if (personnel.getDept_no() == 40) {
			dept_d = "selected";
		}
		if (personnel.getDept_no() == 50) {
			dept_e = "selected";
		}
		if (personnel.getDept_no() == 60) {
			dept_f = "selected";
		}
		if (personnel.getDept_no() == 70) {
			dept_g = "selected";
		}
		if (personnel.getDept_no() == 80) {
			dept_h = "selected";
		}
		%>
	</c:if>
	<c:if test="${wrongRoute }">
		<script type="text/javascript">
			alert('사원 번호를 클릭해주세요');
		</script>
	</c:if>
	<c:if test="${searchError2 }">
		<script type="text/javascript">
			alert('종류를 선택해주세요');
		</script>
	</c:if>

	<div style="display: none;" id="addField">
		<div style="display: inline;">
			<table>
				<tr>
					<td>業務履歴_官庁</td>
					<td><input type="text" name="per_mini_no" value="" <%=c%> /></td>
				</tr>
				<tr>
					<td>業務履歴_部署</td>
					<td><input type="text" name="per_dept_no" value="" <%=c%> /></td>
				</tr>
				<tr>
					<td>期間</td>
					<td><input type="date" name="per_begin_date" value="" <%=c%> />
						- <input type="date" name="per_end_date" value="" <%=c%> /></td>
				</tr>
			</table>
		</div>
	</div>
	<form action="main.do?NoSummit=direct?&searchInput=notNull"
		method="post">

		<table border='1'>
			<tr class="left_box_tr1">
				<td><select class="form-control" name="search">
						<option value="9" <%=search_a%>>選択</option>
						<option value="1" <%=search_b%>>社員番号</option>
						<option value="2" <%=search_c%>>名前</option>
						<option value="3" <%=search_d%>>官庁</option>
						<option value="4" <%=search_e%>>部署</option>
				</select></td>
				<td colspan="12" height="50px"><input type="text"
					name="searchField"
					style="width: 40%; height: 24px; margin: 30px 0;"
					value="${searchField}" required />
					<button type="submit" class="input_btn"
						style="width: 70px; height: 30px;">検索</button></td>

			</tr>
			<tr class="left_box_tr2">
				<td class="td_title">社員番号</td>
				<td class="td_title">名前</td>
				<td class="td_title">部署</td>
				<td class="td_title">官庁</td>
			</tr>
			<c:choose>
				<c:when test="${empty personnelList }">
					<tr class="left_box_tr3">
						<td></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="personnelList" items="${personnelList }">
						<tr class="left_box_tr3">
							<td><a class="no_a"
								href="user.do?choose=user&no=${personnelList.no }&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}">${personnelList.no }</a>
							</td>
							<td>${personnelList.name }</td>
							<td>${personnelList.job_position }</td>
							<td>${personnelList.salary_class }</td>
						</tr>
					</c:forEach>
				</c:otherwise>

			</c:choose>
			<tr class="left_box_tr4">
				<td id="tr_page_a" colspan="22"><c:if
						test="${paging.total/paging.limit<5 }">
						<c:forEach var="currentPage" begin="${paging.startPage }"
							end="${Math.ceil(paging.total/paging.limit)}">
							<a class="page_a"
								href="user.do?currentPage=${ currentPage}&search=${search}&searchField=${searchField}">${currentPage }</a>
						</c:forEach>
					</c:if> <c:if test="${paging.endPage>5 }">
						<a class="page_a"
							href="user.do?startPage=${ paging.startPage-5}&currentPage=${ paging.startPage -1}&search=${search}&searchField=${searchField}">
							前へ</a>
					</c:if> <c:if test="${paging.total/paging.limit>=5 }">
						<c:choose>
							<c:when test="${paging.total/paging.limit<paging.endPage }">
								<c:forEach var="currentPage" begin="${paging.startPage }"
									end="${Math.ceil(paging.total/paging.limit)}">
									<a class="page_a"
										href="user.do?currentPage=${ currentPage}&startPage=${ paging.startPage}&search=${search}&searchField=${searchField}">${currentPage }</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="currentPage" begin="${paging.startPage }"
									end="${ paging.startPage +4 }">
									<a class="page_a"
										href="user.do?currentPage=${ currentPage}&startPage=${ paging.startPage}&search=${search}&searchField=${searchField}">${currentPage }</a>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<c:if test="${paging.endPage != 10 }">
							<a class="page_a"
								href="user.do?startPage=${ paging.endPage+1}&currentPage=${ paging.endPage +1}&search=${search}&searchField=${searchField}">次へ</a>
						</c:if>
					</c:if></td>
			</tr>
		</table>
		<input type="button" value="登録" class="input_btn"
			style="width: 70px; height: 30px;"
			onclick="location.href = 'userJoin.do'" />
	</form>
	<input type="button" value="人的事項" class="input_btn"
		style="width: 70px; height: 30px; margin: 10px;"
		onclick="location.href = 'user.do?choose=user&no=${no }&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}'" />
	<input type="button" value="人事記録" class="input_btn"
		style="width: 70px; height: 30px; margin: 10px;"
		onclick="location.href = 'main.do?choose=personnel&no=${no }&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}'" />

	<!-- 오른쪽 페이지 -->
	<c:choose>
		<c:when test="${choose}">
			<form
				action="main.do?choose=personnel&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}"
				method="post">
				<input type="hidden" name="no" value="${personnel.no }">
				<table border='1'>
					<tr>
						<td colspan="16">
							<h1>人事記録</h1>
						</td>
					</tr>
					<tr>
						<td>社員番号</td>
						<td>${personnel.no}</td>
					</tr>
					<tr>
						<td>職級</td>
						<td><c:choose>
								<c:when test="${modify}">
									<c:choose>
										<c:when test="${personnel.job_position eq'0' }">
											<input type="text" name="job_position" placeholder="1~9"
												<%=a%> />
										</c:when>
										<c:otherwise>
											<input type="text" name="job_position"
												value="${personnel.job_position}" placeholder="1~9" <%=a %> />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${personnel.job_position eq'0' }">
											空いています
										</c:when>
										<c:otherwise>
											<input type="text" name="job_position"
												value="${personnel.job_position}" <%=a %> />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>号俸</td>
						<td><c:choose>
								<c:when test="${modify}">
									<c:choose>
										<c:when test="${personnel.salary_class eq'0' }">
											<input type="text" name="salary_class" placeholder="1~31"
												<%=a%> />
										</c:when>
										<c:otherwise>
											<input type="text" name="salary_class"
												value="${personnel.salary_class}" placeholder="1~31" <%=a %> />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${personnel.salary_class eq'0' }">
											空いています
										</c:when>
										<c:otherwise>
											<input type="text" name="salary_class"
												value="${personnel.salary_class}" <%=a %> />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>官庁</td>
						<td><c:choose>
								<c:when test="${modify}">
									<select name="mini_no">
										<option value="10" <%=mini_a%>>경영처</option>
										<option value="20" <%=mini_b%>>회계처</option>
										<option value="30" <%=mini_c%>>무역처</option>
										<option value="40" <%=mini_d%>>개발처</option>
										<option value="50" <%=mini_e%>>국내영업처</option>
										<option value="60" <%=mini_f%>>국외영업처</option>
										<option value="70" <%=mini_g%>>인사관리처</option>
										<option value="80" <%=mini_h%>>법무처</option>
									</select>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${personnel.mini_no eq '0' }">
											空いています
										</c:when>
										<c:otherwise>
											<input type="text" name="mini_no"
												value="${personnel.mini_name}" readonly />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>部署</td>
						<td><c:choose>
								<c:when test="${modify}">
									<select name="dept_no">
										<option value="10" <%=dept_a%>>경영부</option>
										<option value="20" <%=dept_b%>>회계부</option>
										<option value="30" <%=dept_c%>>무역부</option>
										<option value="40" <%=dept_d%>>개발부</option>
										<option value="50" <%=dept_e%>>국내영업부</option>
										<option value="60" <%=dept_f%>>국외영업부</option>
										<option value="70" <%=dept_g%>>인사관리부</option>
										<option value="80" <%=dept_h%>>법무부</option>
									</select>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${personnel.dept_no eq '0' }">
											空いています
										</c:when>
										<c:otherwise>
											<input type="text" name="dept_no"
												value="${personnel.dept_name}" <%=a%> />
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>給与</td>
						<td><c:choose>
								<c:when test="${money eq '0'}">
						호봉과 직급에 따라 자동으로 입력됩니다.
						</c:when>
								<c:otherwise>
									<input type="text" name="money" value="${money}" readonly />
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>入社日</td>
						<td><c:choose>
								<c:when test="${empty personnel.enter_date }">
									<c:choose>
										<c:when test="${empty modify}">
									空いています
								</c:when>
										<c:otherwise>
											<input type="date" name="enter_date"
												value="${personnel.enter_date }" <%=a %> /> 입력요구
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<input type="date" name="enter_date"
										value="${personnel.enter_date }" <%=a %> />
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>退社日</td>
						<td><c:choose>
								<c:when test="${empty personnel.resign_date }">
									<c:choose>
										<c:when test="${empty modify}">
									空いています
									</c:when>
										<c:otherwise>
											<input type="date" name="resign_date"
												value="${personnel.resign_date }" <%=c %> /> 선택사항
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<input type="date" name="resign_date"
										value="${personnel.resign_date }" <%=c %> />
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${modify}">
								<c:forEach var="eduList" items="${eduList }">
									<tr class="div_5-${eduList.edu_no }">
										<td>教育履歴<input type="hidden"
											name="edu_no${eduList.edu_no }" value="${eduList.edu_no }" /></td>
										<td><input type="text"
											name="edu_content${eduList.edu_no}"
											value="${eduList.edu_content}" <%=a%> /></td>
									</tr>
								</c:forEach>
								<tr id="forEdu">
								</tr>
								<tr>
									<td></td>
									<td style="position: absolute; right: 28%; top: 43%"><input
										<%=b%> id="Edu_addBtn" value="追加" class="input_btn" /><input
										<%=b%> id="Edu_delBtn" value="削除" class="input_btn" /></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${not empty eduList}">
										<c:forEach var="eduList" items="${eduList }">
											<tr class="div_5-${eduList.edu_no }">
												<td>教育履歴<input type="hidden"
													name="edu_no${eduList.edu_no }" value="${eduList.edu_no }" />
												</td>
												<td><input type="text"
													name="edu_content${eduList.edu_no}"
													value="${eduList.edu_content}" <%=a%> /></td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td>教育履歴</td>
										<td>ない</td>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${not empty workexperience }">
								<%
								int i = 0;
								%>
								<c:forEach var="workexperience" items="${workexperience }">
									<%
									String dept_1_a = "", dept_1_b = "", dept_1_c = "", dept_1_d = "", dept_1_e = "", dept_1_f = "", dept_1_g = "",
											dept_1_h = "";

									String mini_1_a = "", mini_1_b = "", mini_1_c = "", mini_1_d = "", mini_1_e = "", mini_1_f = "", mini_1_g = "",
											mini_1_h = "";

									switch (workExperiences.get(i).getDept_no()) {
									case 10:
										dept_1_a = "selected";
										break;
									case 20:
										dept_1_b = "selected";
										break;
									case 30:
										dept_1_c = "selected";
										break;
									case 40:
										dept_1_d = "selected";
										break;
									case 50:
										dept_1_e = "selected";
										break;
									case 60:
										dept_1_f = "selected";
										break;
									case 70:
										dept_1_g = "selected";
										break;
									case 80:
										dept_1_h = "selected";
										break;
									}

									switch (workExperiences.get(i).getMini_no()) {
									case 10:
										mini_1_a = "selected";
										break;
									case 20:
										mini_1_b = "selected";
										break;
									case 30:
										mini_1_c = "selected";
										break;
									case 40:
										mini_1_d = "selected";
										break;
									case 50:
										mini_1_e = "selected";
										break;
									case 60:
										mini_1_f = "selected";
										break;
									case 70:
										mini_1_g = "selected";
										break;
									case 80:
										mini_1_h = "selected";
										break;
									}
									i++;
									%>
									<tr class="div_we-${workexperience.we_no}">

										<td>業務履歴_官庁<input type="hidden"
											name="we_no${workexperience.we_no}"
											value="${workexperience.we_no}" /></td>
										<td><c:choose>
												<c:when test="${modify }">
													<select name="mini_no${workexperience.we_no}">
														<option value="10" <%=mini_1_a%>>경영처</option>
														<option value="20" <%=mini_1_b%>>회계처</option>
														<option value="30" <%=mini_1_c%>>무역처</option>
														<option value="40" <%=mini_1_d%>>개발처</option>
														<option value="50" <%=mini_1_e%>>국내영업처</option>
														<option value="60" <%=mini_1_f%>>국외영업처</option>
														<option value="70" <%=mini_1_g%>>인사관리처</option>
														<option value="80" <%=mini_1_h%>>법무처</option>
													</select>
												</c:when>
												<c:otherwise>
													<input type="text" name="mini_no${workexperience.we_no}"
														value="${workexperience.mini_name}" <%=c%> />
												</c:otherwise>
											</c:choose></td>
									</tr>
									<tr class="div_we-${workexperience.we_no}">
										<td>業務履歴_部署</td>
										<td><c:choose>
												<c:when test="${modify }">
													<select name="dept_no${workexperience.we_no}">
														<option value="10" <%=dept_1_a%>>경영부</option>
														<option value="20" <%=dept_1_b%>>회계부</option>
														<option value="30" <%=dept_1_c%>>무역부</option>
														<option value="40" <%=dept_1_d%>>개발부</option>
														<option value="50" <%=dept_1_e%>>국내영업부</option>
														<option value="60" <%=dept_1_f%>>국외영업부</option>
														<option value="70" <%=dept_1_g%>>인사관리부</option>
														<option value="80" <%=dept_1_h%>>법무부</option>
													</select>
												</c:when>
												<c:otherwise>
													<input type="text" name="dept_no${workexperience.we_no}"
														value="${workexperience.dept_name}" <%=c%> />
												</c:otherwise>
											</c:choose></td>
									</tr>
									<tr class="div_we-${workexperience.we_no}">
										<td>期間</td>
										<td>
											<div>
												<input type="date" name="begin_date${workexperience.we_no}"
													value="${workexperience.start_date }" <%=c%> /> - <input
													type="date" name="end_date${workexperience.we_no}"
													value="${workexperience.end_date }" <%=c%> />
											</div>
										</td>
									</tr>
								</c:forEach>
								<tr id="forWE">
								</tr>
								<tr>
									<td></td>
									<td><input <%=b%> id="WE_addBtn" value="追加"
										class="input_btn" /><input <%=b%> id="WE_delBtn" value="削除"
										class="input_btn" /></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${!modify }">
										<td>業務履歴</td>
										<td>ない</td>
									</c:when>
									<c:otherwise>
										<tr id="forWE">
										</tr>
										<tr>
											<td></td>
											<td style="position: absolute; right: 28%; top: 65%"><input
												<%=b%> id="WE_addBtn" value="追加" class="input_btn" /><input
												<%=b%> id="WE_delBtn" value="削除" class="input_btn" /></td>
										</tr>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td></td>
						<td><c:choose>
								<c:when test="${modify}">
									<input type="submit" value="登録" class="input_btn"
										style="width: 70px; height: 30px;" />
								</c:when>
								<c:otherwise>
									<input type="button"
										onclick="location.href='main.do?choose=personnel&modify=true&no=${no}&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}'"
										value="修正" class="input_btn"
										style="width: 70px; height: 30px;" />
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<form
				action="user.do?search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}"
				method="post">
				<input type="hidden" name="no" value="${user.no }" /> <input
					type="hidden" name="filerealname" value="${user.filerealname }" />
				<input type="hidden" name="filename" value="${user.filename }" /> <input
					type="hidden" name="name" value="${user.name }" /> <input
					type="hidden" name="reg_num" value="${user.reg_num }" />
				<c:choose>
					<c:when test="${empty user.no }">
						<style>
						.right_empty_box {
						display: flex;
						justify-content: center;
						align-items: center;
						margin-top: 100px;
}
						
						
</style>
						<div class="right_empty_box"><h2>検索して社員をクリックしてください。</h2></div>
					</c:when>
					<c:otherwise>
						<style>
.user_tr .user_td_title {
	text-align: center;
}

.user_tr .user_td_content {
	text-align: left;
}

.user_td_title_box {
	position: absolute;
	right: 40%;
	top: 10%;
}
</style>
						<table border='1'>
							<tr>
								<td colspan="16">
									<h1>人的事項</h1>
								</td>
							</tr>
							<tr>
								<td><c:if test="${not empty user.filerealname}">
										<img alt="사진" style="width: 100px; height: 100px;"
											src="upload\2022_상반기_증명사진\<%=user.getFilerealname()%>">
									</c:if></td>
							</tr>
							<tr>
								<td colspan="4">社員番号</td>
								<td colspan="4">${user.no}</td>
								<td colspan="4">名</td>
								<td colspan="4">${user.name}</td>
							</tr>
							<tr>
								<td colspan="4">住民番号</td>
								<td colspan="4">${user.reg_num}</td>
								<td colspan="4">連絡先</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<input class="short_input" type="text" name="phone"
												value="${user.phone}" />
										</c:when>
										<c:otherwise>
											${user.phone}
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td colspan="4">メール</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<input class="long_input" type="text" name="email"
												value="${user.email}" />
										</c:when>
										<c:otherwise>
											${user.email}
										</c:otherwise>
									</c:choose></td>
								<td colspan="4">住所</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<input class="long_input" type="text" name="addr"
												value="${user.addr}" />
										</c:when>
										<c:otherwise>
											${user.addr}
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr style="height: 10px;"></tr>
							<tr>
								<td colspan="4">身長</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="tall" value="${user.tall }" />
										</c:when>
										<c:otherwise>
											${user.tall }
										</c:otherwise>
									</c:choose></td>
								<td colspan="4">体重</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="weight" value="${user.weight }" />
										</c:when>
										<c:otherwise>
											${user.weight }
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td colspan="4">視力</td>
								<td colspan="3">左</td>
								<td colspan="3"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="eye_l" value="${user.eye_l}" />
										</c:when>
										<c:otherwise>
									${user.eye_l}
										</c:otherwise>
									</c:choose></td>
								<td colspan="3">右</td>
								<td colspan="3"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="eye_r" value="${user.eye_r}" />
										</c:when>
										<c:otherwise>
											${user.eye_r}
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr style="height: 10px;"></tr>
							<tr>
								<td colspan="4">性別</td>
								<td colspan="4"><c:if test="${user.gender eq 'M'}">
										<%
										gender_M = "selected";
										%>
									</c:if> <c:if test="${user.gender eq 'F'}">
										<%
										gender_F = "selected";
										%>
									</c:if> <c:choose>
										<c:when test="${modify1 }">
											<select name="gender">
												<option value="M" <%=gender_M%>>男</option>
												<option value="F" <%=gender_F%>>女</option>
											</select>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${user.gender eq 'M'}">
													男
												</c:when>
												<c:otherwise>
													女
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose></td>
								<td colspan="4">結婚可否</td>
								<td colspan="4"><c:choose>
										<c:when test="${modify1 }">
											<select name="marry">
												<option value="Y">既婚者</option>
												<option value="N">未婚者</option>
											</select>
										</c:when>
										<c:otherwise>
											<c:if test="${user.marry eq 'Y' }">
												既婚者
											</c:if>
											<c:if test="${user.marry eq 'N' }">
												未婚者
											</c:if>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr style="height: 10px;"></tr>

							<tr>
								<td colspan="3">障害者</td>
								<td colspan="3"><c:choose>
										<c:when test="${modify1 }">
											<select name="disabled" onchange="disabledCheck(this)">
												<option value="Y">有</option>
												<option value="N">無</option>
											</select>
										</c:when>
										<c:otherwise>
											<c:if test="${user.disabled eq 'Y' }">
												有
											</c:if>
											<c:if test="${user.disabled eq 'N' }">
												無
											</c:if>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td colspan="3">障害者等級</td>
								<td colspan="3"><c:choose>
										<c:when test="${modify1 }">
											<select name="disabled_grade">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
											</select>
										</c:when>
										<c:otherwise>
											<c:if test="${user.disabled eq 'Y' }">
											${user.disabled_grade}等級
										</c:if>
											<c:if test="${user.disabled eq 'N' }">
											無
										</c:if>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td colspan="3">障害登録日</td>
								<td colspan="3"><c:choose>
										<c:when test="${modify1 }">
											<input type="date" name="disabled_day"
												value="${user.disabled_day}" />
										</c:when>
										<c:otherwise>
											<c:if test="${user.disabled eq 'Y' }">
											${user.disabled_day}
										</c:if>
											<c:if test="${user.disabled eq 'N' }">
											無
										</c:if>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr style="height: 20px;"></tr>
							<tr>
								<td colspan="4">卒業名</td>
								<td colspan="1"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="school_name"
												value="${user.school_name}" />
										</c:when>
										<c:otherwise>
											${user.school_name}
										</c:otherwise>
									</c:choose></td>
								<td colspan="4">専攻</td>
								<td colspan="1"><c:choose>
										<c:when test="${modify1 }">
											<input type="text" name="school_major"
												value="${user.school_major}" />
										</c:when>
										<c:otherwise>
										${user.school_major}
										</c:otherwise>
									</c:choose></td>
								<td colspan="4">卒業年度</td>
								<td colspan="1"><c:choose>
										<c:when test="${modify1 }">
											<input type="date" name="school_out"
												value="${user.school_out}" />
										</c:when>
										<c:otherwise>
											${user.school_out}
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td colspan="16">
									<h2>資格取得</h2>
								</td>
							</tr>
							<c:choose>
								<c:when test="${modify1 }">
									<c:forEach var="lic" items="${licenseList }">
										<tr class="div_lic-${lic.lic_no}">
											<td colspan="4">資格</td>
											<td colspan="4"><input type="text"
												name="license${lic.lic_no}" value="${lic.license}" required />
											</td>
											<td colspan="4">資格取得日</td>
											<td colspan="4"><input type="date"
												name="license_day${lic.lic_no}" value="${lic.license_day}"
												required /></td>
											<td><input type="hidden" name="lic_no${lic.lic_no}"
												value="${lic.lic_no}"></td>
										</tr>
									</c:forEach>
									<tr id="forLic"></tr>
									<tr style="position: absolute; right: 38%; top: 67%;">
										<td id="add_div"><input type="button" id="lic_addBtn"
											value="追加" class="input_btn" /> <input type="button"
											id="lic_delBtn" value="削除" class="input_btn" /></td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ empty licenseList }">
										</c:when>
										<c:otherwise>
											<c:forEach var="lic" items="${licenseList }">
												<tr class="div_lic-${lic.lic_no}">
													<td colspan="4">資格</td>

													<td colspan="4">${lic.license}</td>
													<td colspan="4">資格取得日</td>
													<td colspan="4">${lic.license_day}</td>
													<td>${lic.lic_no}</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<tr>
								<td class="user_td_title" colspan="2"><c:choose>
										<c:when test="${modify1}">
											<input type="submit" value="完了"
												style="width: 70px; height: 30px; position: absolute; right: 5%; top: 68%;"
												class="input_btn" />
										</c:when>
										<c:otherwise>
											<input type="button"
												onclick="location.href='user.do?choose=user&modify1=true&no=${user.no}&search=${search}&searchField=${searchField}&currentPage=${ paging.currentPage}&startPage=${ paging.startPage}'"
												value="修正" class="input_btn"
												style="width: 70px; height: 30px; position: absolute; right: 5%; top: 70%" />
										</c:otherwise>
									</c:choose></td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>