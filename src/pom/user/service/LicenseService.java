package pom.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import pom.user.dao.LicenseDAO;
import pom.user.model.License;

public class LicenseService {
	private LicenseDAO licenseDao = new LicenseDAO();
	private Connection conn = null;
	
	public ArrayList<License> GetAllLicenseList(int no) {
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
	
	public ArrayList<License> InsertAllLicense(ArrayList<License> license, int no) {
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
