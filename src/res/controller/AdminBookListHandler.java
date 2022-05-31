package res.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import res.dto.Book;
import res.service.AdminBookService;

public class AdminBookListHandler implements CommandHandler {
	private final static String ADMIN_FORM = "/WEB-INF/res/admin/adminBook/adminBookList.jsp";
	private AdminBookService adminBookService = new AdminBookService();

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {

		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("GET")) {
			return processForm(rq, rp);
		} else {
			System.out.println("error");
			return null;
		}
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp)
			throws SQLException {
		ArrayList<Book> book = new ArrayList<Book>();
		book = adminBookService.selectBookList(book);
		rq.setAttribute("book", book);
		return ADMIN_FORM;
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		return ADMIN_FORM;
	}

}
