package res.member.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import res.admin.member.dao.AdminMemberDAO;
import res.exception.LoginFailException;
import res.member.model.Member;

public class LoginService {
	private AdminMemberDAO memberDao = new AdminMemberDAO();
	private Connection conn;
	public Member login(String id, String password) {
		Member member = new Member();
		try {	
			member = memberDao.selectById(conn, id);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) {
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
