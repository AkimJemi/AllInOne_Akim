package res.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.dao.AdminMemberDAO;
import res.dto.Member;

public class MemberService {
	private AdminMemberDAO memberDao = new AdminMemberDAO();
	private Connection conn;
	public boolean checkUser(String id, String password) {
		boolean result = false;
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
	public ArrayList<Member> getAllMemberList(ArrayList<Member> member) {
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			member = memberDao.selectAll(conn, member);
		}catch (Exception e) {
			System.out.println("MemberService.getAllMemberList()");
		}finally {
			JdbcUtil.close(conn);
		}
		return member;
	}
}
