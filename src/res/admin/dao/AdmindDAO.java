package res.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.book.model.BookModel;

public class AdmindDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private BookModel reservation = null;
	public ArrayList<BookModel> getAllReservationInfo(Connection conn, ArrayList<BookModel> reservations) throws SQLException {
		pstmt = conn.prepareStatement("select * from reservation");
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reservation = new BookModel(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				reservations.add(reservation);
			}
		} catch (Exception e) {
			System.out.println("error : AdmindDAO.getAllReservationInfo()");
		}
		return reservations;
	}
}
