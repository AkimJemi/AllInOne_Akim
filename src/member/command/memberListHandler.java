package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class memberListHandler implements CommandHandler {
	private final static String MEMBER_LIST_FORM = "/WEB-INF/member/memberList.jsp";
	

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("memberListHandler");
		
		return MEMBER_LIST_FORM;
	}
}
