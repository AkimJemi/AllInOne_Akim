package res.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import res.member.dao.MemberDaoss;
import res.member.model.Member;
import res.member.model.User;

public class LoginService {
	private MemberDaoss memberDao = new MemberDaoss();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getId(), member.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
