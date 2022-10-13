package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BookDTO;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@pukkuk.pp.ua:1521:xe";
	String id = "hr";
	String pw = "jeongsumin0701";

	public BookDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<BookDTO> select() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String bookName = rs.getString("book_name");
				String bookLoc = rs.getString("book_loc");

				BookDTO dto = new BookDTO(bookId, bookName, bookLoc);
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}
}
