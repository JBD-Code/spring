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
	<%-- <form action ="<c:url value="j_spring_security_check"/>" method="post">
	 --%>
	 <form action ="${contextPath}/login.html" method="post">
	<table>
	<tr>
		<td>ID</td>
		<td><input type ="text" name ="j_username"></td>
	</tr>
	<tr>
	<td>Password</td>
	<td><input type ="text" name ="j_password"></td>
	</tr>
	<tr>
	<td>
	<input type="submit" value="Login"></td>
	</tr>
	</table>
	</form>
</body>
</html>