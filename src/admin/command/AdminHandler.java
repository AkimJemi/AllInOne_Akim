package admin.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminService;
import member.model.Member;
import mvc.command.CommandHandler;

public class AdminHandler implements CommandHandler {
	private final static String ADMIN_FORM = "WEB-INF/admin/admin.jsp";
	private AdminService adminService = new  AdminService(); 

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp)
			throws Exception {

		if (rq.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(rq, rp);
		} else if (rq.getMethod().equalsIgnoreCase("GET")) {
			return processForm(rq,rp);
		} else {
			System.out.println("error");
			return null;
		}
	}

	private String processForm(HttpServletRequest rq, HttpServletResponse rp) throws SQLException {
		ArrayList<Member> user = adminService.getAllUserInfo();
		rq.setAttribute("user", user);
		return ADMIN_FORM;
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		
		
		
		return ADMIN_FORM;

	}

}
