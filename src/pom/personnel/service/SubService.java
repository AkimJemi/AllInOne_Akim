package pom.personnel.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import pom.main.model.WorkExperienceRequest;
import pom.personnel.SubDAO.SubDAO;
import pom.personnel.model.PersonnelRequest;

public class SubService {
	private SubDAO subDao = new SubDAO();
	private Connection conn;

	public PersonnelRequest ToStringlize(PersonnelRequest subPers) {
		try {
			conn = ConnectionProvider.getConnection();
			subPers = subDao.stringLize(conn, subPers);

		} catch (Exception e) {
			System.out.println("error : SubDAO.subDao()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return subPers;
	}

	public WorkExperienceRequest ToStringlize(WorkExperienceRequest subWE) {
		try {
			conn = ConnectionProvider.getConnection();
			subWE = subDao.WEStringLize(conn, subWE);

		} catch (Exception e) {
			System.out.println("error : SubDAO.subDao()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return subWE;
	}

}
