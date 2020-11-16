<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>     
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
	<form action="${contextPath}/member/addMember.do" method="post" >
		<h2>Member Sign Up</h2>
		<table align="center">
			<tr>
				<td> ID</td>
				<td><input type ="text" name ="id" ></td>	
			</tr>
			<tr>
				<td> Password</td>
				<td><input type ="password" name ="pwd" ></td>	
			</tr>
			<tr>
				<td> Name</td>
				<td><input type ="text" name ="name"></td>	
			</tr>
			<tr>
				<td> E-Mail</td>
				<td><input type ="text" name ="email"></td>	
			</tr>
			<tr>
				<td>
				<input type="submit" value="Sign Up">		
				<input type="reset" value="reset">
				</td>
			</tr>			
		</table> 
	</form>
</body>
</html>