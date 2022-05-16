package book.service;

import java.sql.Connection;

import book.dao.BookDAO;
import jdbc.connection.ConnectionProvider;

public class BookService {
	private BookDAO bookDao = new BookDAO();
	public void bookMember(String no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			bookDao.insert(conn, no);
			conn.commit();
		} catch (Exception e) {
			System.out.println("catch : BookService.bookMember()");
			System.out.println(e.getMessage());
		}
	}
}
