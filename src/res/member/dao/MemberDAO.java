package res.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import res.member.model.Member;

public class MemberDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Member member;

	public boolean checkUser(Connection conn, String id, String password)
			throws SQLException {
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where id = ? and password =?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn,
			ArrayList<Member> members) {
		try {
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				members.add(member);
			}
		} catch (Exception e) {
			System.out.println("catch : MemberDAO.selectAll");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return members;
	}
}
