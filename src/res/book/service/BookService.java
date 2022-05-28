package res.book.service;

import java.sql.Connection;

import jdbc.connection.ConnectionProvider;
import res.book.dao.BookDAO;

public class BookService {
	private BookDAO bookDao = new BookDAO();
	public Boolean bookMember(int no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			conn.commit();
			return bookDao.insert(conn, no);
		} catch (Exception e) {
			System.out.println("catch : BookService.bookMember()");
			System.out.println(e.getMessage());
		}
		return false;
	}
}
