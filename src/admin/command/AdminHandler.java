package admin.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminService;
import mvc.command.CommandHandler;
import reservation.model.Reservation;

public class AdminHandler implements CommandHandler {
	private final static String ADMIN_FORM = "WEB-INF/admin/admin.jsp";
	private AdminService adminService = new AdminService();

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
		ArrayList<Reservation> reservation = new ArrayList<Reservation>();
		reservation = adminService.getAllUserInfo(reservation);
		rq.setAttribute("reservation", reservation);
		return ADMIN_FORM;
	}

	private String processSubmit(HttpServletRequest rq,
			HttpServletResponse rp) {
		return ADMIN_FORM;
	}

}
