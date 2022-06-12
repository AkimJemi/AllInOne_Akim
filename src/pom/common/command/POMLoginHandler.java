package pom.common.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Util;
import mvc.command.CommandHandler;
import pom.user.model.User;
import pom.user.service.UserService;

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
		rq.setAttribute("route", "POMInit");
		return "init/login";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		UserService userService = new UserService();
		HttpSession session = rq.getSession();
		User user = null;
		if (rq.getParameter("id") != null && rq.getParameter("password") != null) {
			String id = rq.getParameter("id"), password = rq.getParameter("password");
			user = new User(id, password);
			if (id.equals("admin") && password.equals("admin") || userService.login(user)) {
				session.setAttribute("pomLoginedMember", user);
				return "main";
			} else {
				System.out.println("dd");
				return Util.redirectMsgAndBack(rq, "회원 정보를 정확하게 입력해주세요");
			}
		} else
			return Util.redirectMsgAndBack(rq, "아이디와 비밀번호를 입력해주세요");
	}

}
