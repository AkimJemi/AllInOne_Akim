package book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookService;
import mvc.command.CommandHandler;

public class bookInsertHandler implements CommandHandler {
	private final static String BOOK_INSERT = "/WEB-INF/res/book/bookList.jsp";
	private BookService bookService = new BookService();
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {
		if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else
			return "error : process";
	}
	
	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		String no = rq.getParameter("no");
		bookService.bookMember(no);
		rq.setAttribute("insert", Boolean.TRUE);
		return "/res/member/list.do";
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		
		return BOOK_INSERT;
	}

}
