<script type="text/javascript">
var key = new Array();
// 로그인
key['1'] = "<%=request.getContextPath()%>/res/login.do?id=admin&password=admin";
// pom
key['2'] = "<%=request.getContextPath()%>/pom/main";
// res
key['3'] = "<%=request.getContextPath()%>/res/main";
key['4'] = "<%=request.getContextPath()%>/res/member/main";
key['5'] = "<%=request.getContextPath()%>/res/member/product/list";
key['6'] = "<%=request.getContextPath()%>/res/member/myPage";

function getKey(keyStroke) {
	if ((event.srcElement.tagName != 'INPUT') && (event.srcElement.tagName != 'TEXTAREA')){
		isNetscape=(document.layers);
		eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
		which = String.fromCharCode(eventChooser).toLowerCase();
		for (var i in key)
			if (which == i) window.location = key[i];
	}
}
document.onkeypress = getKey;
</script>