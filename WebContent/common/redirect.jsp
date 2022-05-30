<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
const alertMsg = '${Msg}'.trim();
if (alertMsg) {
alert(alertMsg);
}
const historyBack = '${historyBack}'.trim();
if(historyBack){
history.back();
}
const replaceURI = '${replaceURI}'.trim();
if(replaceURI){
location.replace(replaceURI);
}
</script>