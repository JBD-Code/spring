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
	<form action="${contextPath}/test03/memberInfo.do" method="post" name="frmMember">
		<h1 style="text-align:center">Member Sign Up</h1>
		<table align="center" >
		<tr align="center"  >
			<td align="center"><p><b>ID</b></p></td>
			<td> <input type="text" name="id" ></td>			
		</tr>
		
		<tr align="center" >
			<td align="center"><p><b>Password</b></p></td>
			<td> <input type="password" name="pwd" ></td>			
		</tr>
		<tr align="center" >
			<td align="center"><p><b>Name</b></p></td>
			<td> <input type="text" name="name" ></td>			
		</tr>
		<tr align="center" >
			<td align="center"><p><b>E-Mail</b></p></td>
			<td> <input type="text" name="email" ></td>			
		</tr>
		<tr>
			<td>
				<input type="submit" value="Sign Up">
				<input type="reset" value="Reset">
			</td>
		</tr>
		</table>
	
	
	</form>
</body>
</html>