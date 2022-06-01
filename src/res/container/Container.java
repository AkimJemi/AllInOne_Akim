package res.container;

import res.controller.AdminBookListHandler;
import res.dao.AdminBookDAO;
import res.dao.AdminDAO;
import res.dao.AdminMemberDAO;
import res.service.AdminBookService;
import res.service.LoginService;
import res.service.MemberService;

public class Container {
	public static AdminBookListHandler adminBookListHandler;
	
	
	public static AdminBookDAO adminBookDao;
	public static AdminDAO adminDao;
	public static AdminMemberDAO adminMemberDao;
	public static AdminBookService adminBookService;
	public static LoginService loginService;
	public static MemberService memberService;
	
	static {
		adminBookListHandler = new AdminBookListHandler();
		adminBookDao = new AdminBookDAO();
		adminDao = new AdminDAO();
		adminMemberDao = new AdminMemberDAO();
		adminBookService = new AdminBookService();
		loginService = new LoginService();
		memberService = new MemberService();
		
		
	}

}
