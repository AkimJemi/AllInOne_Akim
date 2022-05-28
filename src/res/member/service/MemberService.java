package res.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.member.dao.MemberDAO;
import res.member.model.Member;

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
	public ArrayList<Member> getAllMemberList(ArrayList<Member> member) {
		Connection conn = null;
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
