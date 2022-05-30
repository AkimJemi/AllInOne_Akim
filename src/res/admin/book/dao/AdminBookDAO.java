package res.admin.book.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import res.admin.book.model.Book;

public final class AdminBookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Book reservation = null;
	public ArrayList<Book> selectBookList(Connection conn, ArrayList<Book> reservations) {
		try {
			pstmt = conn.prepareStatement("select * from book");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reservation = new Book(rs.getInt(1), rs.getString(2),
						rs.getString(3),rs.getString(4));
				reservations.add(reservation);
			}
		} catch (Exception e) {
			System.out.println("error : AdmindDAO.getAllReservationInfo()");
		}
		return reservations;
	}

	public Boolean insert(Connection conn, int no) throws SQLException {
		pstmt = conn.prepareStatement("insert into book (no, res_nvm , if_res) values ( ?, 'ES100' , ?)");
		try {
			pstmt.setInt(1, no);
			pstmt.setString(2, "YES");
			if (pstmt.executeUpdate() == 1) {
				if (checkBook(conn, no, "YES")) {
					return true;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("catch : BookDAO.insert()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}


	public Boolean check_res(Connection conn, int no, String YesOrNo) {
		try {
			pstmt = conn.prepareStatement("update book set check_res = ? where no = ? and if_res = ?");
			pstmt.setString(1, YesOrNo);
			pstmt.setInt(2, no);
			pstmt.setString(3, "yes");
			if(pstmt.executeUpdate() ==1) {
				if (checkBook(conn, no, "YES" ,YesOrNo)) 
					return true;
			} else 
				return false;
		} catch (Exception e) {
			System.out.println("catch : BookDAO.check_res()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}
	
	private boolean checkBook(Connection conn, int no, String res_no) {
		try {
			pstmt = conn.prepareStatement("select * from book where no = ? and if_res = ?");
			pstmt.setInt(1, no);
			pstmt.setString(2, res_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			System.out.println("catch : BookDAO.checkBook()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		
		return false;
	}
	
	private boolean checkBook(Connection conn, int no, String if_res, String check_res) {
		try {
			pstmt = conn.prepareStatement("select * from book where no = ? and if_res = ? and check_res = ?");
			pstmt.setInt(1, no);
			pstmt.setString(2, if_res);
			pstmt.setString(3, check_res);
			rs = pstmt.executeQuery();
			if (rs.next()) 
				return true;
			
		} catch (Exception e) {
			System.out.println("catch : BookDAO.checkBook()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}
	
}
