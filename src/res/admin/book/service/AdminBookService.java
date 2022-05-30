package res.admin.book.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.admin.book.dao.AdminBookDAO;
import res.admin.book.model.Book;

public class AdminBookService {
	private AdminBookDAO bookDao = new AdminBookDAO();
	private Connection conn;
	public Boolean bookMember(int no) {
		try {
			conn = ConnectionProvider.getConnection();
			return bookDao.insert(conn, no);
		} catch (Exception e) {
			System.out.println("catch : BookService.bookMember()");
			System.out.println(e.getMessage());
		}
		finally {
			JdbcUtil.close(conn);
		}
		return false;
	}
	public Boolean UpdateCheck_Res(int no, String YesOrNo) {
		try {
			conn = ConnectionProvider.getConnection();
			return bookDao.check_res(conn, no, YesOrNo);
		} catch (Exception e) {
			System.out.println("catch : BookService.Check_Res()");
			System.out.println(e.getMessage());
		}
		finally {
			JdbcUtil.close(conn);
		}
		return false;
	}
	public ArrayList<Book> selectBookList(ArrayList<Book> reservation ){
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			reservation = bookDao.selectBookList(conn, reservation);
			conn.commit();
			JdbcUtil.close(conn);
		} catch (Exception e) {
			System.out.println("error : AdminService.getAllUserInfo()");
		}
		finally {
			JdbcUtil.close(conn);
		}
		return reservation;
	}
		
}
