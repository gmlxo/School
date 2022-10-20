<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<section>
		<form action="./memberInsert" method="post">
			userID : <input type="text" name="userid">
			userPW : <input type="text" name="username">
			<button type="submit"> 등록 </button>
		</form>
	</section>

<%@ include file="footer.jsp" %>