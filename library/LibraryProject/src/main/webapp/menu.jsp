<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/style/menStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<header>
			<h1>양영디지털고등학교 홈페이지</h1>
		</header>
		<div class="row">
			<div class="side-menu">

				<%
					MemberVO login = (MemberVO) session.getAttribute("loginOK");
				%>

				<a href="/lib-index.jsp" id="intro">처음으로</a> 
				
				<%
					if(login == null){
				%>
				<a href="/login/lib-login.jsp" id="login">로그인</a>
				<a href="/book/lib-serchBook.jsp" id="search">도서 검색</a>
				<a id="rental">도서 대출 현황</a>
				
				<% }else{ %>
				
				<a href="/logout" id="logout">로그아웃 ( <%= login.getMemberId() %> )</a>
				<a href="/book/lib-searchBook.jsp" id="search">도서 검색</a>
				<a href="/retaBook" id="rental">도서 대출 현황</a>
				<a href="/quit" id="quit">회원탈퇴</a>
				<% } %>
			</div>
			<div class="content">