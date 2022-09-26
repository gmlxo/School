package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	String str;
	int result;

	public BookDAO() {
	}

	public ArrayList<BookVO> getBookList(String key) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		str = "%" + key + "%";
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(key.equals("all")) {
				sql = "select * from lib_book order by book_no asc";
				pstmt = conn.prepareStatement(sql);
			} else {
				sql = "select * from lib_book where title like ? order by book_no asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, str);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookNo(rs.getInt("book_no"));
				vo.setTitle(rs.getString("title"));
				vo.setAuthor(rs.getString("author"));
				vo.setCompany(rs.getString("company"));
				vo.setPrice(rs.getInt("price"));
				vo.setRentaled(rs.getString("rentaled"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("lib_book 테이블 데이터 조회 실패");
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int setRentalField(int bookNo, String status) {
		sql = "update lib_book set rentaled=? where book_no=?";
		result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, bookNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return result;
	}
}