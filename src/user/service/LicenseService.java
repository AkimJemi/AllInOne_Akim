package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.dao.LicenseDAO;
import user.model.License;

public class LicenseService {
	private LicenseDAO licenseDao = new LicenseDAO();
	private Connection conn = null;
	
	public ArrayList<License> GetAllLicenseList(int no) throws SQLException{
		ArrayList<License> licenseList = new ArrayList<License>();
		try {
			conn = ConnectionProvider.getConnection();
			licenseList = licenseDao.SelectAll(conn, no, licenseList);
		} catch (Exception e) {
			System.out.println("error : LicenseService.GetAllLicenseList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return licenseList;
	}
	
	public ArrayList<License> InsertAllLicense(ArrayList<License> license, int no) throws SQLException{
		try {
			conn = ConnectionProvider.getConnection();
			license = licenseDao.InsertAll(conn, license,no);
		} catch (Exception e) {
			System.out.println("error : LicenseServcie.InsertAllLicense()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return license;
	}
	
}
