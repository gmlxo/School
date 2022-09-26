<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp"%>
	<h2> 도서 검색 </h2>
	<a href="/listBook_title=all"> 도서 전체 보기 </a>
	<br><br>
	<form action="/listBook" method="get">
		도서명 : <input type="text" name="book_title">
		<input type="submit" value="검색">
		<input type="reset" value="취소">
	</form>
<%@ include file="/footer.jsp"%>