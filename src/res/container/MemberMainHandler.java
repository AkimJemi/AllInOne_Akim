package res.container;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import res.dto.Member;

public class MemberMainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		Member member = new Member();
		HttpSession session = rq.getSession();
		if (session.getAttribute("loginedMember") != null) {
			member = (Member) session.getAttribute("loginedMember");
			if (member.getId().equals("admin") || member.getPassword().equals("admin"))
				return "member/main";
		}
		rq.setAttribute("route","RESMember");
		return Container.loginHandler.process(rq, rp);
	}

}
