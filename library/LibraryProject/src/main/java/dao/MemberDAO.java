package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.BookVO;
import vo.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean isEist;
	String sql;
	int result;

	public MemberDAO() {
	}
	public ArrayList<BookVO> getBookList(String key){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(key.equals("all")) {
				sql = "select * from lib_book order by book_no asc";
				pstmt = conn.prepareStatement(sql);
			} else {
				sql = "select * from lib_book where title like ? order by book_no asc";
				pstmt = conn.prepareStatement(sql);
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
	
	public MemberVO getMemberDate(String id) {
		MemberVO vo = null;
		sql = "select * from lib_member where member_id=?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAddr(rs.getString("member_addr"));
				vo.setMemberAge(rs.getInt("member_age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("checkLoginUser : sql error");
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return vo;
	}

	public boolean existID(String id) {
		isEist = false;
		sql = "select * from lib_member where member_id=?";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				isEist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("checkLoginUser : sql error");
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return isEist;
	}

	public int removeMember(String id) {
		result = 0;
		sql = "DELETE FROM lib_member WHERE member_id = ?";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insertMember(MemberVO data) {
		result = 0;
		sql = "INSERT INTO lib_book VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getMemberId());
			pstmt.setString(2, data.getMemberPw());
			pstmt.setString(3, data.getMemberName());
			pstmt.setString(4, data.getMemberAddr());
			pstmt.setInt(5, data.getMemberAge());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}