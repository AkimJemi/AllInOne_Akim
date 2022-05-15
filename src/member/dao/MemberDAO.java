package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class MemberDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public boolean checkUser(Connection conn, String id, String password)
			throws SQLException {
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(
					"select * from main where memberid = ? and password =?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result= true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}
}
