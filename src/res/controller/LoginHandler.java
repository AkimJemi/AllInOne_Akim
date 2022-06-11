package res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import res.container.Container;
import res.dto.Member;

public class LoginHandler implements CommandHandler {
	private final static String LOGIN_FORM = "init/login";

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getParameter("id") != null && rq.getParameter("password") != null)
			if (rq.getParameter("id").equals("admin") && rq.getParameter("password").equals("admin")) {
				String id = rq.getParameter("id");
				String password = rq.getParameter("password");
				Member member = new Member(id, password);
				member = Container.loginService.login(member);
				HttpSession sesson = rq.getSession();
				sesson.setAttribute("logindedMember", member);
				return "init/main";
			}
		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("GET")) {
			return processForm(rq, rp);
		} else {
			return null;
		}
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		rq.setAttribute("route", rq.getParameter("route"));
		return LOGIN_FORM;
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		String id = rq.getParameter("id");
		String password = rq.getParameter("password");
		Member member = new Member(id, password);
		member = Container.loginService.login(member);
		HttpSession sesson = rq.getSession();
		sesson.setAttribute("logindedMember", member);
		boolean checkUser = Container.adminMemberService.checkUser(member);

		if (!checkUser) {
			rq.setAttribute("error", "login");
			return LOGIN_FORM + "?error=exist";
		}
		rq.getSession().setAttribute("loginedUser", member);
		return "init/main";
	}
}