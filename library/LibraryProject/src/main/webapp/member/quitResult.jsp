<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/menu.jsp"%>
	<% String msg = (String)session.getAttribute("quit"); %>
	<h2>회원탈퇴 결과 안내</h2>
	<p><%= msg %></p>
<%@ include file="/footer.jsp"%>