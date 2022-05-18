package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.dao.AdmindDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import reservation.model.Reservation;

public class AdminService {
	private AdmindDAO adminDao = new AdmindDAO();

	public ArrayList<Reservation> getAllUserInfo(ArrayList<Reservation> reservation ) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			conn.setAutoCommit(false);
			reservation = adminDao.getAllReservationInfo(conn, reservation);
			conn.commit();
			JdbcUtil.close(conn);
		} catch (Exception e) {
			System.out.println("error : AdminService.getAllUserInfo()");
		}
		return reservation;
	}
}
