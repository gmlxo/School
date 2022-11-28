<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

	<section>
		<% ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("memberList"); %>
		<table>
			<tr>
				<td> 회원번호 </td>
				<td> 회원성명 </td>
				<td> 전화번호 </td>
				<td> 주소 </td>
				<td> 가입일자 </td>
				<td> 고객등급 </td>
				<td> 거주지역 </td>
			</tr>
<%
		if(list != null) {
			for(MemberVO vo : list){
%>
			<tr>
				<td><a href="<%= request.getContextPath() %>/member/updateForm?custno=<%= vo.getCustno() %>"> <%= vo.getCustno() %> </a></td>
				<td><%= vo.getCustname() %></td>
				<td><%= vo.getPhone() %></td>
				<td><%= vo.getAddress() %></td>
				<td><%= vo.getJoindate() %></td>
				<td><%= vo.getGrade() %></td>
				<td><%= vo.getCity() %></td>
			</tr>
<%
			}
		}
%>
		</table>
	</section>

<%@ include file="/footer.jsp" %>