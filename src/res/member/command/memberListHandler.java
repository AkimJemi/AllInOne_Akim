package res.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.member.model.Member;
import res.member.service.MemberService;

public class memberListHandler implements CommandHandler {
	private final static String MEMBER_LIST_FORM = "/WEB-INF/res/member/memberList.jsp";

	private MemberService memberService = new MemberService();
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {
		if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq,rp);
		else if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq,rp);
		else
			return "오류나잉";
	}

	private String processSubmit(HttpServletRequest rq, HttpServletResponse rp) {
		return MEMBER_LIST_FORM;
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		ArrayList<Member> member = new ArrayList<Member>();
		member = memberService.getAllMemberList(member);
		rq.setAttribute("member", member);
		return MEMBER_LIST_FORM;
	}
}
