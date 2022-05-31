package res.service;

import java.sql.Connection;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import res.dao.AdminBookDAO;
import res.dto.Book;

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
	public ArrayList<Book> selectBookList(ArrayList<Book> book ){
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			book = bookDao.selectBookList(conn, book);
			conn.commit();
			JdbcUtil.close(conn);
		} catch (Exception e) {
			System.out.println("error : AdminService.getAllUserInfo()");
		}
		finally {
			JdbcUtil.close(conn);
		}
		return book;
	}
		
}
