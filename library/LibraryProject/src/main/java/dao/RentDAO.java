package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.RentVO;

public class RentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	int result;

	public RentDAO() {
	}

	public ArrayList<RentVO> getRentalList(String userId) {
		ArrayList<RentVO> list = new ArrayList<RentVO>();

		String sqlAll = "select * from rent_book order by rent_no asc";
		String sqlId = "select * from rent_book where member_id=? order by rent_no asc";

		try {
			conn = JDBCUtil.getConnection();
			if (userId.equals("admin")) {
				pstmt = conn.prepareStatement(sqlAll);
			} else {
				pstmt = conn.prepareStatement(sqlId);
				pstmt.setString(1, userId);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RentVO vo = new RentVO();
				vo.setRentNo(rs.getInt("rent_no"));
				vo.setMemberId(rs.getString("memberId"));
				vo.setBookNo(rs.getInt("BookNo"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setBookTitle(rs.getString("rent_no"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return list;
	}

	public RentVO makeRentData(String userId, int bookNo) {
		RentVO vo = null;

		sql = "select a.member_name, b.title from lib_member a, lib_book b where a.member_id=? and b.book_no=?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, bookNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new RentVO();
				vo.setMemberId(userId);
				vo.setBookNo(bookNo);
				vo.setMemberName(rs.getString("member_name"));
				vo.setBookTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rent_book 테이블 데이터 조회 실패");
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public int rentBook(RentVO vo) {
		result = 0;
		sql = "insert into rent_book values(rent_seq.nextval,?,?,?,?)";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setInt(2, vo.getBookNo());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getBookTitle());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return result;
	}
	
	public int deleteRent(int bookNo) {
		result = 0;
		sql = "delete from rent_book where book_no=?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		
		return result;
	}
}