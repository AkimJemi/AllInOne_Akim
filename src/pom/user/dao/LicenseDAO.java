package pom.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import pom.user.model.License;

public class LicenseDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean licenseExist(Connection conn, int no, int lic_no) {
		try {
			pstmt = conn.prepareStatement("select license from license where no=? and lic_no = ?");
			pstmt.setInt(1, no);
			pstmt.setInt(2, lic_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error : LicenseDAO.licenseExist()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return false;
	}

	public ArrayList<License> SelectAll(Connection conn, int no, ArrayList<License> licList) {
		try {
			pstmt = conn.prepareStatement("select * from license where no =?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				License license = new License(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4));
				licList.add(license);
			}
		} catch (Exception e) {
			System.out.println("error: LicenseDAO.SelectAll()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return licList;
	}

	public ArrayList<License> InsertAll(Connection conn, ArrayList<License> license, int no2) {
		int no = 0;
		try {
			int i;
			if (license.size() != 0) {
				for (i = 0; i < 5; i++) {
					no = license.get(0).getNo();
					if (i < license.size()) {
						if (licenseExist(conn, license.get(i).getNo(), license.get(i).getLic_no())) {
							System.out.println("update");
							pstmt = conn.prepareStatement(
									"update license set license=?, license_day=? where no=? and lic_no=?");
							pstmt.setString(1, license.get(i).getLicense());
							pstmt.setDate(2, license.get(i).getLicense_day());
							pstmt.setInt(3, license.get(i).getNo());
							pstmt.setInt(4, license.get(i).getLic_no());
							pstmt.executeUpdate();
						} else {
							System.out.println("insert");
							pstmt = conn.prepareStatement(
									"insert into license (no, lic_no, license, license_day) values (?,?,?,?)");
							pstmt.setInt(1, license.get(i).getNo());
							pstmt.setInt(2, license.get(i).getLic_no());
							pstmt.setString(3, license.get(i).getLicense());
							pstmt.setDate(4, license.get(i).getLicense_day());
							pstmt.executeUpdate();
						}
					} else {
						System.out.println("delete");
						pstmt = conn.prepareStatement("delete from license where no=? and lic_no=?");
						pstmt.setInt(1, no);
						pstmt.setInt(2, i + 1);
						pstmt.executeUpdate();
					}
				}
			} else {
				System.out.println("deleteAll");
				pstmt = conn.prepareStatement("delete from license where no=? ");
				pstmt.setInt(1, no2);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("error : LicenseDAO.InsertAll()");
			System.out.println(e.getMessage());
		}
		return license;
	}

}
