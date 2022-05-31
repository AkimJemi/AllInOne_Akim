package pom.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import pom.main.model.WorkExperience;

public class WEDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<WorkExperience> InsertAll(Connection conn, ArrayList<WorkExperience> workExperiences, int no2) {
		int no = 0;
		try {
			int i;
			System.out.println("workExperiences.size() : " + workExperiences.size());
			System.out.println("workExperiences.size() : " + no);
			if (workExperiences.size() != 0) {
				for (i = 0; i < 5; i++) {
					no = workExperiences.get(0).getNo();
					if (i < workExperiences.size()) {
						if (ifweno_Exist(conn, workExperiences.get(i).getNo(), workExperiences.get(i).getWe_no())) {
							pstmt = conn.prepareStatement(
									"update workexperience set dept_no = ?  ,mini_no =? ,start_date=? ,end_date= ? where no = ? and we_no =?");
							pstmt.setInt(1, workExperiences.get(i).getDept_no());
							pstmt.setInt(2, workExperiences.get(i).getMini_no());
							pstmt.setDate(3, workExperiences.get(i).getStart_date());
							pstmt.setDate(4, workExperiences.get(i).getEnd_date());
							pstmt.setInt(5, workExperiences.get(i).getNo());
							pstmt.setInt(6, workExperiences.get(i).getWe_no());
							pstmt.executeUpdate();
						} else {
							pstmt = conn.prepareStatement(
									"insert into workexperience ( no ,we_no, dept_no ,mini_no ,start_date ,end_date) values (?, ?, ?, ?, ?, ? )");
							pstmt.setInt(1, workExperiences.get(i).getNo());
							pstmt.setInt(2, workExperiences.get(i).getWe_no());
							pstmt.setInt(3, workExperiences.get(i).getDept_no());
							pstmt.setInt(4, workExperiences.get(i).getMini_no());
							pstmt.setDate(5, workExperiences.get(i).getStart_date());
							pstmt.setDate(6, workExperiences.get(i).getEnd_date());
							pstmt.executeUpdate();
						}
					} else {
						pstmt = conn.prepareStatement("delete from workexperience where no = ? and we_no = ?");
						pstmt.setInt(1, no);
						pstmt.setInt(2, i + 1);
						pstmt.executeUpdate();
					}
				}
			} else {
				System.out.println("deleteAll");
				pstmt = conn.prepareStatement("delete from workexperience where no = ?");
				pstmt.setInt(1, no2);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("error : WEDAO.InsertAll()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return workExperiences;
	}

	private boolean ifweno_Exist(Connection conn, int no, int we_no) {
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

	public ArrayList<WorkExperience> SelectAll(Connection conn, int no, ArrayList<WorkExperience> weList) {
		try {
			WorkExperience workExperience = new WorkExperience();
			pstmt = conn.prepareStatement("select * from workexperience where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				workExperience = new WorkExperience(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getDate(5), rs.getDate(6));
				weList.add(workExperience);
			}

		} catch (Exception e) {
			System.out.println("error : WEDAO.SelectAll()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return weList;
	}
}
