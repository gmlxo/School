<%@page import="vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp" %>
	<% BookVO data =(BookVO)request.getAttribute("selectBook"); %>
	<form action="/updateBook" method="post">
		<table border="0" align="center" width="300px">
			<tr>
				<td>도서관리</td>
				<td><input type="text" name="isbn" value="<%= data.getIsbn() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>책이름</td>
				<td><input type="text" name="title" value="<%= data.getTitle() %>"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author" value="<%= data.getAuthor() %>"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="company" value="<%= data.getCompany() %>"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price" value="<%= data.getPrice() %>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="50px">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="/footer.jsp" %>