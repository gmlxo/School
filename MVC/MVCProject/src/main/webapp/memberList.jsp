<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<section>
		<table>
			<thead>
				<tr>
					<th> 사용자 ID </th>
					<th> 사용자 이름 </th>
					<th> 삭제 </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${memberList}">
				<tr>
					<td>${item.userid}</td>
					<td>${item.username}</td>
					<td><a class="del" href="${pageContext.request.contextPath}/memberDelete?userId=${item.userid}">삭제 </a></td>
				</tr>
				</c:forEach>
				</tbody>
		</table>
		<br>
		<a class="del" href="${pageContext.request.contextPath }/index.jsp">홈으로 </a>
	</section>

<%@ include file="footer.jsp" %>