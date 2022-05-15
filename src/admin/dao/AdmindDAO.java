package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.Member;

public class AdmindDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ArrayList<Member> AllUser = new ArrayList<Member>();
	private Member member = null;
	public ArrayList<Member> getAllUserInfo(Connection conn) throws SQLException {
		pstmt = conn.prepareStatement("select * from unit");
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				AllUser.add(member);
			}
		} catch (Exception e) {
			System.out.println("AdmindDAO.getAllUserInfo()");
		}
		return AllUser;
	}

}
