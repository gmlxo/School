<%@page import="vo.RentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp"%>
<%
	ArrayList<RentVO> list = (ArrayList<RentVO>) request.getAttribute("rent_list");
%>

<h2>도서 대여 결과 화면</h2>

<table width="800px" border="1" align="center">
	<tr>
		<th>사용자ID</th>
		<th>대출자</th>
		<th>책이름</th>
		<th>반납하기</th>
	</tr>
<%
		if (list != null) {
			for (RentVO data : list) {
%>
	<tr>
		<td> <%= data.getMemberId() %> </td>
		<td> <%= data.getMemberName() %> </td>
		<td> <%= data.getBookTitle() %> </td>
<%
		if (login == null) {
					out.print("<td></td>");
				} else {
%>
		<td> <a href="/returnBook?kookNo=<%= data.getBookNo() %>"> 반납하기 </a> </td>
<%
		}
%>

	</tr>

<%
			}
		}
%>
</table>
<%@ include file="/footer.jsp"%>