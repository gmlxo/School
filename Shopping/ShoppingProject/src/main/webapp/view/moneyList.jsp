<%@page import="vo.MoneyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<MoneyVO> list  = (ArrayList<MoneyVO>) request.getAttribute("moneyList"); %>
	<section>
		<h1>회원매출조회</h1>
		<table>
			<tr>
				<td> 회원번호 </td>
				<td> 회원성명 </td>
				<td> 고객등급 </td>
				<td> 매출 </td>
			</tr>
<%
	int n = 0;
	if(list != null){
		for(MoneyVO date: list){
%>
			<tr>
				<td> <%= date.getCustno() %></td>
				<td> <%= date.getCustname() %></td>
				<td> <%= date.getGrade() %></td>
				<td> <%= date.getPrice() %></td>
			</tr>
<%
		}
	}
%>
		</table>
	</section>

<%@ include file="/footer.jsp" %>