<%@page import="vo.MemberVO"%>
<%@page import="vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp"%>
	<h2> 도서 조회 결과 </h2>
<%
	ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("book_list");
%>
	<table width="800px" border="1" align="center">
		<tr>
			<th>도서번호</th>
			<th>책이름</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
			<th>대여하기</th>
		</tr>
<%
	if(list != null){
		for(BookVO data : list) {		
%>
		<tr>
			<td><%= data.getBookNo() %></td>
			<td><%= data.getTitle() %></td>
			<td><%= data.getAuthor() %></td>
			<td><%= data.getCompany() %></td>
			<td><%= data.getPrice() %></td>
<%
	if(login == null){
		out.print("<td></td>");
	} else{
		if(data.getRentaled().equals("t")){
			out.print("<td> 대여중 </td>");
		} else{
%>
			<th>대여하기</th>
<%
		}
	}
%>
		</tr>
<%
		}
	}
%>
	</table>
<%@ include file="/footer.jsp"%>