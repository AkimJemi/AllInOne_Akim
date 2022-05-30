package mvc.command;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class MySQLHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		String URI = rq.getRequestURI();
		String[] URIBites = URI.split("/");
		String ProjectURI = URIBites[1];
		String ControllerURI = URIBites[2];
//		String MethodURI = URIBites[3];
		System.out.println(URI);
		System.out.println(ProjectURI);
		System.out.println(ControllerURI);
//		System.out.println(MethodURI);

		Connection conn = null;
		try {
			ResultSet rs = null;
			String query = rq.getParameter("query");
			System.out.println(query);
			conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
//			rs.last();
			int rowCount = rs.getRow();

			System.out.println("columnCount : " + columnCount);
			System.out.println("rowCount : " + rowCount);
			int i = 1;
//			rs.first();
			while (rs.next()) {
					int j = 1;
					while (j != 7) {
							System.out.println(rs.getInt(j));
						if (rs.getInt(i) ==1)
//						if (rs.getString(i) != null)
							System.out.println(rs.getString(j));
						j++;
					}
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : MySQLHandler");

		} finally {
			JdbcUtil.close(conn);
		}

		return null;
	}
	
//	public static List<Map<String, Object>> selectRows(SecSql sql) throws MysqlUtilException {
//		List<Map<String, Object>> rows = new ArrayList<>();
//
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//
//		try {
////			stmt = sql.getPreparedStatement(getConnection());
//			rs = stmt.executeQuery();
//			ResultSetMetaData metaData = rs.getMetaData();
//			int columnSize = metaData.getColumnCount();
//
//			while (rs.next()) {
//				Map<String, Object> row = new HashMap<>();
//
//				for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
//					String columnName = metaData.getColumnName(columnIndex + 1);
//					Object value = rs.getObject(columnName);
//
//					if (value instanceof BigDecimal) {
//						row.put(columnName, ((BigDecimal)value).intValue());
//					}
//					else if (value instanceof BigInteger) {
//						row.put(columnName, ((BigInteger)value).intValue());
//					}
//					else if (value instanceof Long) {
//						int numValue = (int) (long) value;
//						row.put(columnName, numValue);
//					} else if (value instanceof Timestamp) {
//						String dateValue = value.toString();
//						dateValue = dateValue.substring(0, dateValue.length() - 2);
//						row.put(columnName, dateValue);
//					} else {
//						row.put(columnName, value);
//					}
//				}
//
//				rows.add(row);
//			}
//		} catch (SQLException e) {
//			
//		} finally {
//			JdbcUtil.close(stmt, rs);
//		}
//		return rows;
//	}

}
