package res.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import res.dto.Book;
import res.dto.MemberAndBook;

public final class AdminBookDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<MemberAndBook> selectMemberAndBookList(Connection conn, ArrayList<MemberAndBook> books) {
		try {
			pstmt = conn.prepareStatement(
					"select m.no, m.id,m.password,m.email,m.name,m.gender,m.age,b.res_nvm, b.if_res,b.check_res from member m left join book b on m.no = b.no");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				books.add(new MemberAndBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : AdmindDAO.selectBookList()");
		}
		return books;
	}

	
public ArrayList<Book> selectBookList(Connection conn, ArrayList<Book> book) {
	try {
		pstmt = conn.prepareStatement(
				"select * from book where if_res ='yes'");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			book.add(new Book(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("error : AdmindDAO.selectBookList()");
	}
	return book;
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
			if (pstmt.executeUpdate() == 1) {
				if (checkBook(conn, no, "YES", YesOrNo))
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

	public Boolean if_res(Connection conn, int no, String yesNo) {
		try {
			System.out.println(no);
			System.out.println(yesNo);
			pstmt = conn.prepareStatement("update book set if_res = ? where no = ?");
			pstmt.setString(1, yesNo);
			pstmt.setInt(2, no);
			if (pstmt.executeUpdate() == 1) {
				if (checkIf_res(conn, no,  yesNo))
					return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("catch : BookDAO.if_res()");
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return false;
	}

	private boolean checkIf_res(Connection conn, int no,  String yesNo) {
		try {
			pstmt = conn.prepareStatement("select * from book where no = ? and if_res = ?");
			pstmt.setInt(1, no);
			pstmt.setString(2, yesNo);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			System.out.println("catch : BookDAO.checkIf_res()");
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
			System.out.println("test4");
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
