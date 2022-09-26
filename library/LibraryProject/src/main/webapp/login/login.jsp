<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style/loginStyle.css">
</head>
<body>
	<h2> 양영디지털고등학교 도서관 로그인 페이지</h2>

    	<form action="/login" method="post">
        <div class="login-container">
            <label><b>User ID</b></label>
            <input type="text" placeholder="Enter User ID" name="id">

            <label><b>password</b></label>
            <input type="password" placeholder="Enter Password" name="pw">
            <input type="submit" value="Login">
            <a href="/member/lib-register.jsp"> 회원가입</a>
        </div>
    </form>
<%@ include file="/footer.jsp" %>