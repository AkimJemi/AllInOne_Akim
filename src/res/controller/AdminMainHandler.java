package res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class AdminMainHandler implements CommandHandler {
	private final static String MAIN_FORM = "/WEB-INF/res/admin/adminMain.jsp";

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return MAIN_FORM;
	}
}
