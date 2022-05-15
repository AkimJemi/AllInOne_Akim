package member.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;

public class MemberService {
	private MemberDAO memberDao = new MemberDAO();
	public boolean checkUser(String id, String password) {
		boolean result = false;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			result = memberDao.checkUser(conn, id, password);
		} catch (Exception e) {
			return false;
		}finally {
			JdbcUtil.close(conn);
		}
		return result;
	}
}
