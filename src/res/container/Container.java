package res.container;

import res.controller.AdminBookListHandler;
import res.controller.AdminBookUpdateHandler;
import res.controller.AdminMemberInsertHandler;
import res.controller.AdminMemberListHandler;
import res.controller.LoginHandler;
import res.controller.MemberProductListHandler;
import res.dao.AdminBookDAO;
import res.dao.AdminMemberDAO;
import res.service.AdminBookService;
import res.service.AdminMemberService;
import res.service.LoginService;

public class Container {
	
	
	public static LoginHandler loginHandler;
	public static LoginService loginService;
	
	public static AdminBookListHandler adminBookListHandler;
	public static AdminMemberListHandler adminMemberListHandler;
	public static AdminBookUpdateHandler adminBookCheckResUpdateHandler;
	public static AdminMemberInsertHandler adminMemberInsertHandler;
	
	public static MemberProductListHandler memberProductListHandler;
	
	public static AdminBookService adminBookService;
	public static AdminMemberService adminMemberService;
	
	public static AdminBookDAO adminBookDao;
	public static AdminMemberDAO adminMemberDao;
	
	
	static {
		loginService = new LoginService();
		loginHandler = new LoginHandler();
		
		adminBookListHandler = new AdminBookListHandler();
		adminMemberListHandler = new AdminMemberListHandler();
		adminBookCheckResUpdateHandler = new AdminBookUpdateHandler();
		adminMemberInsertHandler = new AdminMemberInsertHandler();
		
		memberProductListHandler = new MemberProductListHandler();
		
		adminBookService = new AdminBookService();
		adminMemberService = new AdminMemberService();
		
		adminBookDao = new AdminBookDAO();
		adminMemberDao = new AdminMemberDAO();
		
		
		
	}

}
