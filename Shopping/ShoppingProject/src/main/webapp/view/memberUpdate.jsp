<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

	<section>
		<h1>홈쇼핑 회원 정보 수정</h1>
<% MemberVO vo = (MemberVO) request.getAttribute("member"); %>
		<form action="<%= request.getContextPath() %>/member/memberUpdate" method="post">
			<table>
				<tr>
					<td> 회원번호 </td>
					<td> <input type="number" value="${vo.custno}" name="custno">
				</tr>
				<tr>
					<td> 회원성명 </td>
					<td> <input type="number" value="${vo.custname}" name="custname">
				</tr>
				<tr>
					<td> 회원전화 </td>
					<td> <input type="number" value="${vo.phone}" name="phone">
				</tr>
				<tr>
					<td> 회원주소 </td>
					<td> <input type="number" value="${vo.address}" name="address">
				</tr>
				<tr>
					<td> 가입일자 </td>
					<td> <input type="number" value="${vo.joindate}" name="joindate">
				</tr>
				<tr>
					<td> 고객등급[A:VIP, B:일반, C:직원] </td>
					<td> <input type="number" value="${vo.grade}" name="grade">
				</tr>
				<tr>
					<td> 도시코드 </td>
					<td> <input type="number" value="${vo.city}" name="city">
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<a href="<%= request.getContextPath() %>/member/memberList"> 
							<input type="button" value="조회">
						</a>
					</td>
				</tr>
			</table>
		</form>
	</section>

<%@ include file="/footer.jsp" %>