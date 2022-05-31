package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import user.model.User;

public class UserDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public User select(Connection conn, User user, int no) throws SQLException{
		pstmt = conn.prepareStatement("select * from user where no = ?");
		pstmt.setInt(1, no);
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), 
						rs.getString(9), rs.getString(10), rs.getDate(11), rs.getInt(12), rs.getInt(13), 
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), 
						rs.getString(18), rs.getInt(19), rs.getDate(20), rs.getString(21), rs.getDate(22));
			}
		} catch (Exception e) {
			System.out.println("error : UserDAO.selectAll.select()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return user;
	}
	
	public User modify(Connection conn, User user) throws SQLException{
		try {
			pstmt = conn.prepareStatement("update user set filename=?, filerealname=?, phone=?, addr=?, email=?, tall=?, weight=?, eye_l=?, eye_r=?, marry=?, disabled=?, disabled_grade=?, disabled_day=?, license=?, license_day=? where no=? ");
			
			pstmt.setString(1, user.getFilename());
			pstmt.setString(2, user.getFilerealname());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, user.getTall());
			pstmt.setInt(7, user.getWeight());
			pstmt.setString(8, user.getEye_l());
			pstmt.setString(9, user.getEye_r());
			pstmt.setString(10, user.getMarry());
			pstmt.setString(11, user.getDisabled());
			pstmt.setInt(12, user.getDisabled_grade());
			pstmt.setDate(13, user.getDisabled_day());
			pstmt.setString(14, user.getLicense());
			pstmt.setDate(15, user.getLicense_day());
			pstmt.setInt(16, user.getNo());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("error : UserDAO.modify()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return user;
	}

}