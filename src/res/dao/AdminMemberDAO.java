package res.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import res.dto.Member;

public class AdminMemberDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Member member;

	public boolean checkUser(Connection conn, Member member) throws SQLException {
		boolean result = false;
		try {
			pstmt = conn.prepareStatement("select * from member where id = ? and password =?");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
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

	public ArrayList<Member> selectAll(Connection conn, ArrayList<Member> members) {
		try {
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				no, id, password, email, name, gender, age
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
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

	public Member login(Connection conn, Member member) {
		try {
			pstmt = conn.prepareStatement("select * from member where id = ? and password = ? ");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println("catch : MemberDAO.login");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		try {
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			pstmt = conn
					.prepareStatement("insert into member ( id, password, name, email, gender, age ) values ( ?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setInt(6, member.getAge());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("catch : MemberDAO.insertMember()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}

	public Member selectMember(Connection conn, Member member) {
		try {
			pstmt = conn.prepareStatement("select * from member where id = ? and password = ? ");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println("catch : MemberDAO.selectMember()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return member;
	}
}
