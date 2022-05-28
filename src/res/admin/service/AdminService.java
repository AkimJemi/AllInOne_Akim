package res.admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.admin.dao.AdmindDAO;
import res.book.model.BookModel;

public class AdminService {
	private AdmindDAO adminDao = new AdmindDAO();

	public ArrayList<BookModel> getAllUserInfo(ArrayList<BookModel> reservation ) throws SQLException {
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
