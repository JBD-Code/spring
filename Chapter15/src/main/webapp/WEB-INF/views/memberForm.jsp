<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align:center;">Member Form</h3>
	<form action="${contextPath}/member/memberInsert" method="post">
		<table align="center">
			<tr>
				<td>ID<td>
				<td><input type="text" name="id"></td>
			</tr>		
			<tr>
				<td>Password<td>
				<td><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td>Name<td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email<td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr >
				<td >
					<input type="submit" value="Sign Up">
					<input type="Reset" value="Reset">
				</td>
			</tr>			
		
		
		</table>
	</form>	 
</body>
</html>