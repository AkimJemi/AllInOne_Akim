<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<style>

#div_0{
	width:100%;
}
#div_1{
	background-color:red;
	width: 30%;
	float: left;
}
#div_2{
	background-color:pink;
	width: 65%;
	float: right;
}
#div_3{
	background-color:orange;
	width: 65%;
	float: right;
}
#div_4{
	background-color:yellow;
	width: 65%;
	float: right;
}
#div_5{
	background-color:green;
	width: 65%;
	float: right;
}
#div_6{
	background-color:olive;
	width: 65%;
	float: right;
}
#div_7{
	background-color:blue;
	width: 65%;
	float: right;
}
#div_8{
	background-color:maroon;
	width: 65%;
	float: right;
}
#div_9{
	background-color:purple;
	width: 65%;
	float: right;
}
#div_10{
	background-color:lime;
	width: 65%;
	float: right;
}
#div_11{
	background-color:gray;
	width: 65%;
	float: right;
}
</style>
</head>
<body>
<div id="div_0">
	<div id="div_1">
		<div>
			<div>
				<div><input type="text" name="search"
					style="width: 75%; height: 24px; margin: 30px 0;" value="" />
					<button class="input_btn" type="submit" style="width: 70px; height: 30px;">検索</button>
				</div>
			</div>
			<div>
				<div class="div_title">社員番号</div>
				<div class="div_title">名前</div>
				<div class="div_title">部署</div>
				<div class="div_title">官庁</div>
			</div>
			<c:forEach var="personnelList" items="${personnelList }">
				<div class="box_line">
					<div><a class="no_a" href="user.do?no=${personnelList.no }">${personnelList.no }</a>
					</div>
					<div>${personnelList.name }</div>
					<div>${personnelList.job_position }</div>
					<div>${personnelList.salary_class }</div>
				</div>
			</c:forEach>
		</div>
		<input type="button" value="登録" style="width: 70px; height: 30px;"
		onclick="location.href = 'userForm.do'" />
	</div>
	
	
	<div id="div_2">
		<input type="button" value="人的事項" style="width: 70px; height: 30px;"
			onclick="location.href = 'main.do?choose=user&no=${personnel.no }'" />
		<input type="button" value="人事記録" style="width: 70px; height: 30px;"
			onclick="location.href = 'main.do?choose=personnel&no=${personnel.no }'" />
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
<form action="user.do" method="post">
<div>
	<div id="div_3">
		<div>
			<div>
				<input name="picture" type="image" name="filename"	value="${user.filename}" />
			</div>
		<div>
			<div>写真登録</div>
			<input type="file" value=""/>
		</div>
		</div>
	</div>
	<div id="div_4">
		<div class="div_top_l">
			<div class="div_top_l_l">社員番号</div>
			<div class="div_top_l_l">名</div>
		</div>
		<div class="div_top_r">
			<input class="short_input" type="text" name="no" value="${user.no}" readonly />
			<input class="short_input" type="text" name="name" value="${user.name}" readonly />
		</div>
	</div>
	<div id="div_5">
		<div class="div_top_l">
			<div class="div_top_l_l">住民番号</div>
			<div class="div_top_l_l">連絡先</div>
			</div>
		</div>
		<div class="div_top_r">
			<input class="short_input" type="text" name="reg_num" value="${user.reg_num}" readonly />
			<input class="short_input" type="text" name="phone" value="${user.phone}" />
		</div>
	</div>
	<div id="div_6">
		<div>
			<div class="div_long">メール</div>
			<div class="div_long">住所</div>
		</div>
		<div>
			<input class="long_input" type="text" name="email" value="${user.email}" />
			<input class="long_input" type="text" name="addr"	value="${user.addr}" readonly />
		</div>
	</div>
	
	<div id="div_7">	
		<div class="div_l_l">
			<div>身長</div>
			<div>視力</div>
			<div>結婚可否</div>
		</div>
		<div class="div_l_r">
			<input type="text" name="tall"	value="${user.tall }" />
			<div>左</div>
			<input type="text" name="eye_l" value="${user.eye_l}" />
			<div>右</div>
			<input type="text" name="eye_r" value="${user.eye_r}" />
			<c:choose>
				<c:when test="${ modify }">
					<select name="marry">
						<option value="Y">既婚者</option>
						<option value="N">未婚者</option>
					</select>
				</c:when>
			</c:choose>
		</div>
	</div>
	
	<div id="div_8">
		<div>
			<div>体重</div>
			<div><input type="text" name="weight" value="${user.weight}" /></div>
		</div>
		<div>
			<div>性別</div>
			<div><input type="text" name="gender" value="${user.gender}" /></div>
		</div>
	</div>
	
	<div id="div_9">
		<div>
			<div>障害者</div>
				<c:choose>
					<c:when test="${ modify }">
							<select name="disabled">
								<option value="Y">有</option>
								<option value="N">無</option>
							</select>
					</c:when>
				</c:choose>
		</div>
		<div>
			<div>障害者等級</div>
				<c:choose>
					<c:when test="${ modify }">
							<select name="disabled_grade">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
					</c:when>
				</c:choose>
		</div>
		<div>
			<div>障害登録日</div>
			<div><input type="date" name="disabled_day"	value="${user.disabled_day}" /></div>
		</div>
	</div>
	
	<div id="div_10">
		<div class="div_l_l">
			<div>卒業名</div>
			<div>専攻</div>
			<div>卒業年度</div>
		</div>
		<div class="div_l_r">
			<div><input type="text" name="school_name" value="${user.school_name}" /></div>
			<div><input type="text" name="school_major"	value="${user.school_major}" /></div>
			<div><input type="date" name="school_out" value="${user.school_out}" /></div>
		</div>
	</div>
	
	<div id="div_11">
		<div>
			<div>資格取得</div>
		</div>
		<div>
			<div>資格</div>
			<div>資格取得日</div>
		</div>
		<div>
			<div><input type="text" name="license" value="${user.license}" /></div>
			<div><input type="date" name="license_day" value="${user.license_day}" /></div>
		</div>
	</div>
	
	<div id="div_12">
		<div>
			<div></div>
			<div><input value="追加" /></div>
		</div>
	</div>
	
	<div id="div_11">
		<div>
			<div>
				<div>
				<c:choose>
					<c:when test="${modify}">
						<input type="submit" value="完了"
							style="width: 70px; height: 30px;" />
					</c:when>
					<c:otherwise>
						<input type="button"
							onclick="location.href='user.do?choose=user&modify=true&no=${user.no}'"
							value="修正" style="width: 70px; height: 30px;" />
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>
	</div>
</form>
</div>
</body>
</html>