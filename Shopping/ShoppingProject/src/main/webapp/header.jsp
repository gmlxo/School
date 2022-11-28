<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver1.0 </h1>
	</header>
	<nav>
		<ul>
			<li><a href="<%= request.getContextPath() %>/member/insertForm"> 회원등록 </a></li>
			<li><a href="<%= request.getContextPath() %>/member/memberList"> 회원목록조회/수정 </a></li>
			<li><a href="<%= request.getContextPath() %>/member/moneyList"> 회원매출조회 </a></li>
			<li><a href="<%= request.getContextPath() %>/index.jsp"> 홈으로 </a></li>
		</ul>
	</nav>