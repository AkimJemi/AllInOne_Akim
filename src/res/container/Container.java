package res.container;

import res.controller.AdminBookUpdateHandler;
import res.controller.AdminBookListHandler;
import res.controller.AdminMemberInsertHandler;
import res.controller.AdminMemberListHandler;
import res.dao.AdminBookDAO;
import res.dao.AdminDAO;
import res.dao.AdminMemberDAO;
import res.service.AdminBookService;
import res.service.LoginService;
import res.service.AdminMemberService;

public class Container {
	public static AdminBookListHandler adminBookListHandler;
	public static AdminMemberListHandler adminMemberListHandler;
	public static AdminBookUpdateHandler adminBookCheckResUpdateHandler;
	public static AdminMemberInsertHandler adminMemberInsertHandler;
	
	
	public static AdminBookDAO adminBookDao;
	public static AdminDAO adminDao;
	public static AdminMemberDAO adminMemberDao;
	public static AdminBookService adminBookService;
	public static LoginService loginService;
	public static AdminMemberService memberService;
	
	static {
		adminBookListHandler = new AdminBookListHandler();
		adminMemberListHandler = new AdminMemberListHandler();
		adminBookCheckResUpdateHandler = new AdminBookUpdateHandler();
		adminMemberInsertHandler = new AdminMemberInsertHandler();
		
		adminBookDao = new AdminBookDAO();
		adminDao = new AdminDAO();
		adminMemberDao = new AdminMemberDAO();
		
		adminBookService = new AdminBookService();
		loginService = new LoginService();
		memberService = new AdminMemberService();
		
		
	}

}
