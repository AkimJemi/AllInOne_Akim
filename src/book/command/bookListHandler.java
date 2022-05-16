package book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class bookListHandler implements CommandHandler {
	private final static String BOOK_LIST_FORM = "/WEB-INF/book/bookList.jsp";
	
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {
		System.out.println("dd");
		if (rq.getMethod().equalsIgnoreCase("GET"))
			return processForm(rq, rp);
		else if (rq.getMethod().equalsIgnoreCase("POST"))
			return processSubmit(rq, rp);
		else
			return "error : process";
	}
	private String processForm(HttpServletRequest rq, HttpServletResponse rp) {
		return BOOK_LIST_FORM;
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		rq.setAttribute("", "");
		return BOOK_LIST_FORM;
	}

}
