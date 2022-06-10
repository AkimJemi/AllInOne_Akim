package res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.dto.Member;
import res.service.AdminMemberService;

public class AdminMemberInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		return null;
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {

		return "admin/member/insert";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		String id = rq.getParameter("id");
		String password = rq.getParameter("password");
		String name = rq.getParameter("name");
		String email = rq.getParameter("email");
		String gender = rq.getParameter("gender");
		int age = Integer.parseInt(rq.getParameter("age"));
		AdminMemberService adminMemberService = new AdminMemberService();
		Member member = new Member(id, password, name, email, gender, age);
		Member members = new Member(id, password, name, email, gender, age);
		member = adminMemberService.InsertMember(member);
		if (member != null) {
			rq.setAttribute("readonly", Boolean.TRUE);
			rq.setAttribute("member", member);
			return "admin/member/insert";
		} else {
			rq.setAttribute("error", Boolean.TRUE);
			rq.setAttribute("member", members);
			return "admin/member/insert";
		}

	}

}
