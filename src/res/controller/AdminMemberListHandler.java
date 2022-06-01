package res.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.dto.Member;
import res.dto.MemberAndBook;
import res.service.AdminBookService;
import res.service.MemberService;

public class AdminMemberListHandler implements CommandHandler {
	private final static String ADMIN_MEMBER_LIST_FORM = "/WEB-INF/res/admin/adminMember/adminMemberList.jsp";
	private MemberService memberService = new MemberService();
	private AdminBookService adminBookService = new AdminBookService();
	
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
		return ADMIN_MEMBER_LIST_FORM;
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		ArrayList<MemberAndBook> book = new ArrayList<MemberAndBook>();
		
//		ArrayList<Book> book = new ArrayList<Book>();
		book = adminBookService.selectBookList(book);
		rq.setAttribute("book", book);
		System.out.println(book.size());
		ArrayList<Member> member = new ArrayList<Member>();
		member = memberService.getAllMemberList(member);
		rq.setAttribute("member", member);
		return ADMIN_MEMBER_LIST_FORM;
	}
}
