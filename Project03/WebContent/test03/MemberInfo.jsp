<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1"  align="center" width="35%">
		<tr align="center" bgcolor="lightgreen">
			<td>ID</td>
			<td>${id}</td> 
		</tr>		
		<tr align="center" bgcolor="lightgreen">
			<td>Password</td>
			<td>${pwd}</td> 
		</tr>
		<tr align="center" bgcolor="lightgreen">
			<td>Name</td>
			<td>${name}</td> 
		</tr>
		<tr align="center" bgcolor="lightgreen">
			<td>E-mail</td>
			<td>${email}</td> 
		</tr>
	</table>

</body>
</html>