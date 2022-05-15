package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.dao.AdmindDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.model.Member;

public class AdminService {
	private AdmindDAO adminDao = new AdmindDAO();
	private ArrayList<Member> member = null;

	public ArrayList<Member> getAllUserInfo() throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			conn.setAutoCommit(false);
			member = adminDao.getAllUserInfo(conn);
			conn.commit();
			JdbcUtil.close(conn);
		} catch (Exception e) {
			System.out.println("error : AdminService.getAllUserInfo()");
		}
		return member;
	}
}
