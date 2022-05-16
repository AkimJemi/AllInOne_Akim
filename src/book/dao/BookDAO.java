package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public final class BookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void insert(Connection conn, String no) throws SQLException {
		pstmt = conn.prepareStatement("insert into reservation (no, revNum , ifreservation) values ( ?, 'ES100' , ?)");
		try {
		pstmt.setInt(1, Integer.parseInt(no));
		pstmt.setString(2, "YES");
		pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("catch : BookDAO.insert()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
	}
}
