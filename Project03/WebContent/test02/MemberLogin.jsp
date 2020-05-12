<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action ="${contextPath}/test02/login.do" method="post" name="frmLogin">
		<table border = "1"  align="center">
			<tr align="center" bgcolor="lightgreen">
				<td>ID</td>
				<td><input type="text" name="id" value="" size="20"></td> 
			</tr>		
			<tr align="center" bgcolor="lightgreen">
				<td>Password</td>
				<td><input type="password" name="pwd" value="" size="20"></td> 
			</tr>
			<tr colspan="2" >	
				<td >
					<input type="submit" value="Sign In">
					<input type="reset" value="Reset">
				</td>
			</tr>
			
		
		</table>


	</form>
	

</body>
</html>