package res.container;

import res.dao.AdminBookDAO;
import res.dao.AdminDAO;
import res.dao.AdminMemberDAO;
import res.service.AdminBookService;
import res.service.LoginService;
import res.service.MemberService;

public class Container {
	public static AdminBookDAO adminBookDao;
	public static AdminDAO adminDao;
	public static AdminMemberDAO adminMemberDao;
	public static AdminBookService adminBookService;
	public static LoginService loginService;
	public static MemberService memberService;
	
	static {
		adminBookDao = new AdminBookDAO();
		adminDao = new AdminDAO();
		adminMemberDao = new AdminMemberDAO();
		adminBookService = new AdminBookService();
		loginService = new LoginService();
		memberService = new MemberService();
		
		
	}

}
