package res.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import res.member.model.Member;

public class MemberDaoss {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null; // 쿼리문에 ? 를 사용하고, 객체를 캐시에 담아 재사용
		ResultSet rs = null; // select의 결과를 저장하는 객체.
		try {
			pstmt = conn
					.prepareStatement("select * from main where memberId=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(rs.getString("memberid"),
						rs.getString("name"), rs.getString("password"));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
