package pom.personnel.SubDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.JdbcUtil;
import pom.main.model.WorkExperienceRequest;
import pom.personnel.model.PersonnelRequest;

public class SubDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private PersonnelRequest subPerReq = new PersonnelRequest();

	public PersonnelRequest stringLize(Connection conn, PersonnelRequest subWE) {

		try {
			pstmt = conn.prepareStatement("select money from salary where salary_class = ? and job_position = ?");
			pstmt.setInt(1, subWE.getSalary_class());
			pstmt.setInt(2, subWE.getJob_position());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subPerReq.setMoney(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		try {
			pstmt = conn.prepareStatement("select dept_name from dept where dept_no = ?");
			pstmt.setInt(1, subWE.getDept_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subPerReq.setDept_name(rs.getString(1));
			}

		} catch (Exception e) {
		} 
		try {
			pstmt = conn.prepareStatement("select mini_name from ministry where mini_no = ?");
			pstmt.setInt(1, subWE.getMini_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subPerReq.setMini_name(rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		return subPerReq;
	}
	
	public WorkExperienceRequest WEStringLize(Connection conn, WorkExperienceRequest subWE) {
		try {
			pstmt = conn.prepareStatement("select dept_name from dept where dept_no = ?");
			pstmt.setInt(1, subWE.getDept_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subWE.setDept_name(rs.getString(1));
			}
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			
		}
		try {
			pstmt = conn.prepareStatement("select mini_name from ministry where mini_no = ?");
			pstmt.setInt(1, subWE.getMini_no());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subWE.setMini_name(rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return subWE;
	}
}
