package jdbc;

import javax.servlet.http.HttpServletRequest;

public class Util {
	public static String jdbcUrl;
	
	
	public static String redirectMsgAndReplace(HttpServletRequest rq, String Msg, String replaceURI) {
		rq.setAttribute("Msg", Msg);
		rq.setAttribute("replaceURI", rq.getContextPath() + "/"+ replaceURI);
		System.out.println(Msg);
		System.out.println(replaceURI);
		return "/common/redirect";
	}
	
	public static String redirectMsgAndBack(HttpServletRequest rq, String Msgs) {
		rq.setAttribute("historyBack", Boolean.TRUE);
		rq.setAttribute("Msg", Msgs);
		return "/common/redirect";
	}

	public static String resultMsg(HttpServletRequest rq, Boolean result, String condition, String T, String F) {
		if(result)
			rq.setAttribute(condition +"", T);
		else
			rq.setAttribute(condition +"", F);
		return "/common/redirect.jsp";
	}
	
	

	public static String getJdbcUrl() {
		return jdbcUrl;
	}

	public static void setJdbcUrl(String jdbcUrl) {
		Util.jdbcUrl = jdbcUrl;
	}
	
}
