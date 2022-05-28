package res.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public final class BookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Boolean insert(Connection conn, int no) throws SQLException {
		pstmt = conn.prepareStatement("insert into reservation (no, revNum , ifreservation) values ( ?, 'ES100' , ?)");
		try {
		pstmt.setInt(1, no);
		pstmt.setString(2, "YES");
		pstmt.executeUpdate();
		if(insertCheck(conn,no)) {
			return true;
		}
		}catch (Exception e) {
			System.out.println("catch : BookDAO.insert()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}

	private boolean insertCheck(Connection conn, int no) {
		try {
			pstmt = conn.prepareStatement("select * from member where no = ?");
		pstmt.setInt(1, no);
		pstmt.setString(2, "YES");
		rs = pstmt.executeQuery();
		if(rs.next()){
			return true;
		}
		}catch (Exception e) {
			System.out.println("catch : BookDAO.insertCheck()");
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}
}
