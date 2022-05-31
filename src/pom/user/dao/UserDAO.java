package pom.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import pom.user.model.License;
import pom.user.model.User;

public class UserDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public User select(Connection conn, User user, int no) throws SQLException {
		pstmt = conn.prepareStatement("select * from user where no = ?");
		pstmt.setInt(1, no);
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getDate(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getDate(20));
			}
		} catch (Exception e) {
			System.out.println("error : UserDAO.selectAll.select()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return user;
	}

	public User modify(Connection conn, User user) throws SQLException {
		try {
			pstmt = conn.prepareStatement(
					"update user set filename=?, filerealname=?, phone=?, addr=?, email=?, tall=?, weight=?, eye_l=?, eye_r=?, marry=?, disabled=?, disabled_grade=?, disabled_day=? where no=? ");

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
			pstmt.setInt(14, user.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("error : UserDAO.modify()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return user;
	}

	public void insert(Connection conn, User user) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO USER(name, reg_num, phone, addr, email, school_name, school_major, school_out, tall, weight, eye_l, eye_r, gender, marry, disabled, disabled_grade, disabled_day, filename, filerealname)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);")) {
			pstmt.setString(1, user.getName());
			/*
			 * pstmt.setString(2, user.getFilerealName()); pstmt.setString(3,
			 * user.getName());
			 */
			pstmt.setInt(2, user.getReg_num());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getSchool_name());
			pstmt.setString(7, user.getSchool_major());
			pstmt.setDate(8, user.getSchool_out());
			pstmt.setInt(9, user.getTall());
			pstmt.setInt(10, user.getWeight());
			pstmt.setString(11, user.getEye_l());
			pstmt.setString(12, user.getEye_r());
			pstmt.setString(13, user.getGender());
			pstmt.setString(14, user.getMarry());
			pstmt.setString(15, user.getDisabled());
			pstmt.setInt(16, user.getDisabled_grade());
			pstmt.setDate(17, user.getDisabled_day());
			pstmt.setString(18, user.getFilename());
			pstmt.setString(19, user.getFilerealname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : UserDAO.insert()");

		}
	}

	public Boolean checkUser(Connection conn, int no) throws SQLException {
		Boolean result = false;
		pstmt = conn.prepareStatement("select * from user where reg_num = ?");
		pstmt.setInt(1, no);
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("error : UserDAO.selectAll.select()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}

	public ArrayList<License> insertAllLic(Connection conn, ArrayList<License> licList) {
		int no = 0;
		try {
			int i;
			for (i = 0; i < 5; i++) {
				if (licList.get(0) != null) {
					no = licList.get(0).getNo();
					if (i < licList.size()) {
						if (iflicno_Exist(conn, licList.get(i).getNo(), licList.get(i).getLic_no())) {
							System.out.println("lic_update");
							pstmt = conn.prepareStatement(
									"update license set dept_no = ?  ,lic_no =? ,license=? ,license_day= ? where no = ? and lic_no =?");
							pstmt.setInt(1, licList.get(i).getNo());
							pstmt.setInt(2, licList.get(i).getLic_no());
							pstmt.setString(3, licList.get(i).getLicense());
							pstmt.setDate(4, licList.get(i).getLicense_day());
							pstmt.setInt(4, licList.get(i).getNo());
							pstmt.setInt(4, licList.get(i).getLic_no());
							pstmt.executeUpdate();
						} else {
							System.out.println("lic_insert");
							pstmt = conn.prepareStatement(
									"insert into license ( no ,lic_no, license ,license_day) values (?, ?, ?, ? )");
							pstmt.setInt(1, licList.get(i).getNo());
							pstmt.setInt(2, licList.get(i).getLic_no());
							pstmt.setString(3, licList.get(i).getLicense());
							pstmt.setDate(4, licList.get(i).getLicense_day());
							pstmt.executeUpdate();
						}
					} else {
						System.out.println("lic_delete");
						pstmt = conn.prepareStatement("delete from license where no = ? and lic_no = ?");
						pstmt.setInt(1, no);
						pstmt.setInt(2, i + 1);
						pstmt.executeUpdate();
					}
				} else {
					pstmt = conn.prepareStatement("lic_delete from license where no = ?");
					pstmt.setInt(1, no);
					pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			System.out.println("error : UserDAO.insertAllLic()");
			System.out.println(e.getMessage());
		}
		return licList;
	}
	private boolean iflicno_Exist(Connection conn, int no, int we_no) {
		try {
			pstmt = conn.prepareStatement("select we_no from workexperience where no = ? and we_no = ?");
			pstmt.setInt(1, no);
			pstmt.setInt(2, we_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error : WEDAO.ifweno_Exist()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}

	public Boolean reg_numCheck(Connection conn, int reg_num) {
		try {
			pstmt = conn.prepareStatement("select * from user where reg_num = ?");
			pstmt.setInt(1, reg_num);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error : WEDAO.ifweno_Exist()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}

}
