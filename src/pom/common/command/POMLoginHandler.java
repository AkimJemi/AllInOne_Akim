package pom.common.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;

public class POMLoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else
			System.out.println("error : MainHandler.process()");
		return null;
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("route") == null)
			return Util.redirectMsgAndBack(rq, "route가 없습니다");
		else
			rq.setAttribute("route", rq.getParameter("route"));
		
		System.out.println(rq.getParameter("route"));
		return "/WEB-INF/init/login.jsp";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		return null;
	}

}
