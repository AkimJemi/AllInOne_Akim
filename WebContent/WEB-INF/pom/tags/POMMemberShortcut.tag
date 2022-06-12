<script type="text/javascript">
var key = new Array();	
key['1'] = "<%=request.getContextPath()%>/res/login.do?id=admin&password=admin";
// pom
key['2'] = "<%=request.getContextPath()%>/pom/main?route=POMInit";
// res
key['3'] = "<%=request.getContextPath()%>/pom/login?id=admin&password=admin";
key['4'] = "<%=request.getContextPath()%>/pom/member/main";
key['5'] = "<%=request.getContextPath()%>/pom/member/product/list";
key['6'] = "<%=request.getContextPath()%>/pom/member/myPage";

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