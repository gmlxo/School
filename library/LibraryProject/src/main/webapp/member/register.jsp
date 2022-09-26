<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/menu.jsp"%>
	<h2>회원 가입 화면</h2>
    <form action="/register" method="post">
        <table width="500px" border="1" align="center">
            <tr>
                <td>회원 ID</td>
                <td><input type="text" name="memberID"></td>
            </tr>
            <tr>
                <td>회원 PW</td>
                <td><input type="password" name="memberPW"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="memberName"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="memberAddr"></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input type="text" name="memberAge"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="가입">&nbsp;&nbsp;
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
<%@ include file="/footer.jsp"%>