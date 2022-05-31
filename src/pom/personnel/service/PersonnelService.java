package pom.personnel.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import pom.main.model.Paging;
import pom.personnel.dao.PersonnelDAO;
import pom.personnel.model.Personnel;
import user.model.User;

public class PersonnelService {
	private Connection conn;
	private PersonnelDAO personnelDao = new PersonnelDAO();
	private ArrayList<Personnel> personnelList = new ArrayList<Personnel>();

	public ArrayList<Personnel> getAllPersonnel(ArrayList<Personnel> personnelList) {
		try {
			conn = ConnectionProvider.getConnection();
			personnelList = personnelDao.selectAll(conn, personnelList);
		} catch (Exception e) {
			System.out.println("error : personnelDao.getAllPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return personnelList;
	}

	public Personnel getPeronsonel(Personnel personnel, int no) {
		try {
			conn = ConnectionProvider.getConnection();
			personnel = personnelDao.select(conn, personnel, no);
		} catch (Exception e) {
			System.out.println("error : personnelDao.getPeronsonel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return personnel;
	}

	public Personnel modifyPersonnel(Personnel personnel) {
		try {
			conn = ConnectionProvider.getConnection();
			personnel = personnelDao.modify(conn, personnel);

		} catch (Exception e) {
			System.out.println("error : personnelDao.modifyPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return personnel;
	}

	public ArrayList<Personnel> getSearchPersonnel(int search, String searchField, Paging paging) {
		try {
			conn = ConnectionProvider.getConnection();
			int total = personnelDao.getTotalPage(conn, search, searchField);
			paging.setTotal(total);
			personnelList = personnelDao.getSearch(conn, search, searchField, paging);

		} catch (Exception e) {
			System.out.println("error : personnelDao.getSearchPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return personnelList;
	}

	public void AddPersonnel(User user) {
		Boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			result = personnelDao.insert(conn, user);
			if (result) {
				conn.commit();
			}
		} catch (Exception e) {
			System.out.println("error : personnelDao.AddPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public int getTotalPage(int search, String searchField) {
		int total = 0;
		try {
			conn = ConnectionProvider.getConnection();
			total = personnelDao.getTotalPage(conn, search, searchField);

		} catch (Exception e) {
			System.out.println("error : personnelDao.getSearchPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return total;
	}
}
