package res.book.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.book.service.BookService;

public class bookInsertHandler implements CommandHandler {
	private final static String BOOK_INSERT = "/WEB-INF/res/book/bookList.jsp";
	private BookService bookService = new BookService();
	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {
		if(rq.getParameter("no")==null) {
			rq.setAttribute("Error", "선택하신 번호가 존재하지 않습니다.");
			return "/WEB-INF";//AKIM
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
		if(result) 
			rq.setAttribute("insertResult", Boolean.TRUE);
		else 
			rq.setAttribute("insertResult", Boolean.FALSE);
			
		return "/res/member/list.do";
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		
		return BOOK_INSERT;
	}

}
