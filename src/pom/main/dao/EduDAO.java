package pom.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import pom.main.model.Edu;

public class EduDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Edu> selectAllEduByNo(Connection conn, ArrayList<Edu> eduList, int no) {
		try {
			pstmt = conn.prepareStatement("select * from edu where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Edu edu = new Edu(rs.getInt(1), rs.getInt(2), rs.getString(3));
				eduList.add(edu);
			}
		} catch (Exception e) {
			System.out.println("error : EduDAO.selectAllEduByNo()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);

		}
		return eduList;
	}

	public ArrayList<Edu> InsertAll(Connection conn, ArrayList<Edu> eduList, int no2) {
		int no = 0;
		try {
			int i;
			if (eduList.size() != 0) {
				for (i = 0; i < 5; i++) {
					no = eduList.get(0).getNo();
					if (i < eduList.size()) {
						if (ifweno_Exist(conn, eduList.get(i).getNo(), eduList.get(i).getEdu_no())) {
							pstmt = conn.prepareStatement(
									"update edu set edu_no = ?  , edu_content=? where no = ? and edu_no =?");
							pstmt.setInt(1, eduList.get(i).getEdu_no());
							pstmt.setString(2, eduList.get(i).getEdu_content());
							pstmt.setInt(3, eduList.get(i).getNo());
							pstmt.setInt(4, eduList.get(i).getEdu_no());
							pstmt.executeUpdate();
						} else {
							pstmt = conn
									.prepareStatement("insert into edu ( no ,edu_no, edu_content) values (?, ?, ?)");
							pstmt.setInt(1, eduList.get(i).getNo());
							pstmt.setInt(2, eduList.get(i).getEdu_no());
							pstmt.setString(3, eduList.get(i).getEdu_content());
							pstmt.executeUpdate();
						}
					} else {
						pstmt = conn.prepareStatement("delete from edu where no = ? and edu_no = ?");
						pstmt.setInt(1, no);
						pstmt.setInt(2, i + 1);
						pstmt.executeUpdate();
					}
				}
			} else {
				pstmt = conn.prepareStatement("delete from edu where no = ?");
				pstmt.setInt(1, no2);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("error : WEDAO.InsertAll()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return eduList;
	}

	private boolean ifweno_Exist(Connection conn, int no, int edu_no) {
		try {
			pstmt = conn.prepareStatement("select edu_no from edu where no = ? and edu_no = ?");
			pstmt.setInt(1, no);
			pstmt.setInt(2, edu_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error : WEDAO.ifeduno_Exist()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}

}
