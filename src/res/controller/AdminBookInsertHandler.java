package res.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;
import res.dto.Member;
import res.service.AdminBookService;
import res.service.MemberService;

public class AdminBookInsertHandler implements CommandHandler {
	private final static String MEMBER_LIST_FORM = "/WEB-INF/res/admin/adminMember/adminMemberList.jsp";
	private AdminBookService bookService = new AdminBookService();
	private MemberService memberService = new MemberService();
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
		 {
		if(rq.getParameter("no")==null) {
			Util.redirectMsgAndBack(rq, "존재하지 않는 회원번회입니다");
			return "common/redirect.jsp";//AKIM
		}
			
			
		if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else
			return "error : process";
	}
	
	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		int no =Integer.parseInt(rq.getParameter("no"));
		Boolean result = bookService.bookMember(no);
		ArrayList<Member> member = new ArrayList<Member>();
		member = memberService.getAllMemberList(member);
		rq.setAttribute("member", member);
		Util.resultMsg(rq, result, "insertResult","예약 성공", "예약 실패");
		return MEMBER_LIST_FORM;
		
	}
	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		return MEMBER_LIST_FORM;
	}

}
