package res.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.dao.AdminMemberDAO;
import res.dto.Member;
import res.exception.LoginFailException;

public class LoginService {
	private AdminMemberDAO memberDao = new AdminMemberDAO();
	private Connection conn;

	public Member login(Member member) {
		try {
			conn = ConnectionProvider.getConnection();
			member = memberDao.login(conn, member);
			if (member == null) {
				throw new LoginFailException();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return member;
	}

}
