<%@page import="vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/menu.jsp" %>
    
    <% ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("booklist"); %>
	<h1> 도서 전체 확인</h1>
	<table border="1" align="center" width="800px">
  		<tr>
    		<th>도서코드</th>
    		<th>책이름</th>
    		<th>저자</th>
    		<th>출판사</th>
    		<th>가격</th>
    		<th>삭제</th>
    		<th>수정</th>
  		</tr>
<%
	if(list != null){
		for(BookVO data : list){
%>			
		<tr>
			<td><%=data.getIsbn() %></td>
			<td><%=data.getTitle() %></td>
			<td><%=data.getAuthor() %></td>
			<td><%=data.getCompany() %></td>
			<td><%=data.getPrice() %></td>
			<td><a href="/updateBook?isbn=<%=data.getIsbn()%>"> 수정 </a></td>
			<td><a href="/deleteBook?isbn=<%=data.getIsbn()%>"> 삭제 </a></td>
		</tr>
<%			
		}
	}
%>
	</table>
<%@ include file="/footer.jsp" %>
</body>
</html>