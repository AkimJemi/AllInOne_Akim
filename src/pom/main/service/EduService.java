package pom.main.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import pom.main.dao.EduDAO;
import pom.main.model.Edu;

public class EduService {
	private Connection conn;
	private EduDAO eduDao = new EduDAO();

	public ArrayList<Edu> GetAllEduList(int no) {
		ArrayList<Edu> eduList = new ArrayList<Edu>();
		try {
			conn = ConnectionProvider.getConnection();
			eduList = eduDao.selectAllEduByNo(conn, eduList, no);
		} catch (Exception e) {
			System.out.println("error : EduService.eduList()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return eduList;
	}

	public ArrayList<Edu> InsertAllEdu(ArrayList<Edu> eduList, int no) {
		try {
			conn = ConnectionProvider.getConnection();
			eduList= eduDao.InsertAll(conn, eduList,no);

		} catch (Exception e) {
			System.out.println("error : WEService.InsertAllWE()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(conn);
		}
		return eduList;
	}
}
