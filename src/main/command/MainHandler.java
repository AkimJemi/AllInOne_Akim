package main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class MainHandler implements CommandHandler {
	private final static String MAIN_FORM = "/WEB-INF/res/main/main.jsp";

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return MAIN_FORM;
	}
}
