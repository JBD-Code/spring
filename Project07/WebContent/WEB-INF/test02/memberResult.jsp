<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login</title>
</head>
<body>
		<table align="center">
			<tr align="center" bgcolor="lightblue">
				<td>ID</td>
				<td>${id}</td>	
			</tr>	
			<tr align="center" bgcolor="lightblue">
				<td>Password</td>
				<td>${pwd}</td>	
			</tr>
			<tr align="center" bgcolor="lightblue">
				<td>Name</td>
				<td>${name}</td>	
			</tr>
			<tr align="center" bgcolor="lightblue">
				<td>Email</td>
				<td>${email}</td>	
			</tr>
		</table>
</body>
</html>