package res.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Util;
import mvc.command.CommandHandler;
import res.dto.Book;
import res.dto.MemberAndBook;
import res.service.AdminBookService;

public class AdminBookUpdateHandler implements CommandHandler {
	private String BOOK_LIST_FORM = "null";
	private AdminBookService bookService = new AdminBookService();
	private AdminBookService adminService = new AdminBookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) {
		ArrayList<MemberAndBook> memberAndBook = new ArrayList<MemberAndBook>();
		ArrayList<Book> book = new ArrayList<Book>();
		int no;
		String type;
		String yesNo;
		Boolean result = false;
		if (rq.getParameter("no") != null)
			no = Integer.parseInt(rq.getParameter("no"));
		else
			return Util.redirectMsgAndBack(rq, "해당 번호를 찾을 수 없습니다.");

		if (rq.getParameter("type") == null)
			return Util.redirectMsgAndBack(rq, "type을 찾을 수 없습니다.");
		else
			type = rq.getParameter("type");

		if (rq.getParameter("yesNo") == null)
			return Util.redirectMsgAndBack(rq, "yesNo를 찾을 수 없습니다.");
		else
			yesNo = rq.getParameter("yesNo");

		if (type.equals("if_res")) {
			System.out.println("test");
			result = bookService.UpdateIf_res(no, yesNo);
			if (result) {
				memberAndBook = adminService.selectMemberAndBookList(memberAndBook);
				rq.setAttribute("member", memberAndBook);
				BOOK_LIST_FORM = "admin/member/list";
			}
			else
				return Util.redirectMsgAndBack(rq, "이미 취소 상태입니다");

		} else if (type.equals("check_res")) {
			result = bookService.UpdateCheck_Res(no, yesNo);
			if (result) {
				book = adminService.bookList(book);
				rq.setAttribute("book", book);
				BOOK_LIST_FORM = "admin/book/list";
			}
			else
				return Util.redirectMsgAndBack(rq, "이미 취소 상태입니다");
		}


		return BOOK_LIST_FORM;
	}
}
