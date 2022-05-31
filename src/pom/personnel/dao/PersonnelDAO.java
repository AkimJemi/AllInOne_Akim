package pom.personnel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import pom.main.model.Paging;
import pom.personnel.model.Personnel;
import user.model.User;

public class PersonnelDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Personnel> selectAll(Connection conn, ArrayList<Personnel> personnelList) {
		try {
			pstmt = conn.prepareStatement("select * from personnel");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				personnelList.add(new Personnel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			System.out.println("error : PersonnelDAO.selectAll()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return personnelList;
	}

	public Personnel select(Connection conn, Personnel personnel, int no) {
		try {
			pstmt = conn.prepareStatement("select * from personnel where no = ? ");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				personnel = new Personnel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
			}
		} catch (Exception e) {
			System.out.println("error : PersonnelDAO.select()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return personnel;
	}

	public Personnel modify(Connection conn, Personnel personnel) {
		try {
			pstmt = conn.prepareStatement(
					"update personnel set job_position = ? , salary_class =? ,mini_no=? ,dept_no =?,enter_date=? ,resign_date=?  where no = ? ");
			pstmt.setInt(1, personnel.getJob_position());
			pstmt.setInt(2, personnel.getSalary_class());
			pstmt.setInt(3, personnel.getMini_no());
			pstmt.setInt(4, personnel.getDept_no());
			pstmt.setDate(5, personnel.getEnter_date());
			pstmt.setDate(6, personnel.getResign_date());
			pstmt.setInt(7, personnel.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("error : PersonnelDAO.modify()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return personnel;
	}

	public ArrayList<Personnel> getSearch(Connection conn, int search, String searchField, Paging paging) throws SQLException {
		try {
			String colName = "";
			switch (search) {
			case 9:
				break;
			case 1:
				colName = "no";
				break;
			case 2:
				colName = "name";
				break;
			case 3:
				colName = "mini_no";
				break;
			case 4:
				colName = "dept_no";
				break;
			}
			String sql = "select * from personnel where " + colName + " like ? limit 10 offset ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchField + "%");
			pstmt.setInt(2, (paging.getCurrentPage()-1)*10);
			rs = pstmt.executeQuery();
			return makeList(rs);

		} finally {
			JdbcUtil.close(pstmt, rs);
		}
	}

	private ArrayList<Personnel> makeList(ResultSet rs) throws SQLException {
		ArrayList<Personnel> list = new ArrayList<>();

		while (rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			int dept_no = rs.getInt("dept_no");
			int mini_no = rs.getInt("mini_no");
			Personnel subPers = new Personnel(no, name, dept_no, mini_no);
			list.add(subPers);
		}
		return list;
	}

	public Boolean insert(Connection conn, User user) {
		Boolean result = false;
		try {
			pstmt = conn.prepareStatement(
					"insert into personnel ( no, name,job_position,salary_class,money,mini_no,dept_no) values ( ?, ? ,0,0,0,0,0)");
			pstmt.setInt(1, user.getNo());
			pstmt.setString(2, user.getName());
			pstmt.executeUpdate();
			if (result = checkPersonnel(user)) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("error : PersonnelDAO.insert()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}

	private Boolean checkPersonnel(User user) {
		Connection con = null;
		Boolean result = false;
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement("select * from personnel where no = ?");
			pstmt.setInt(1, user.getNo());
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("error : PersonnelDAO.checkPersonnel()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(con);
		}
		return result;
	}

	public int getTotalPage(Connection conn, int search, String searchField) {
		try {
			String colName = "";
			switch (search) {
			case 9:
				break;
			case 1:
				colName = "no";
				break;
			case 2:
				colName = "name";
				break;
			case 3:
				colName = "mini_no";
				break;
			case 4:
				colName = "dept_no";
				break;

			}
			String sql = "select count(*) from personnel where " + colName + " like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchField + "%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				search = rs.getInt(1);
			}

		}catch (Exception e) {
			System.out.println("error : PersonnelDAO.getTotalPage()");
			System.out.println(e.getMessage());

		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return search;
	}
}
