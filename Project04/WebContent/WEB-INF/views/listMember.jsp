<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align:center">Member List</h2>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightblue">
			<td><b>ID</b></td>	
			<td><b>Password</b></td>	
			<td><b>Name</b></td>	
			<td><b>Email</b></td>	
			<td><b>JoinDate</b></td>	
		</tr>
		<c:choose>
		<c:when test="${memberList ==null}"><tr >
			<td>등록된 회원이 없습니다 </td>
		</tr>	
		</c:when>
		<c:when test="${memberList!=null}">
			<c:forEach var="member" items="${memberList}">
				<tr align="center">
					<td>${member.id} </td>
					<td>${member.pwd} </td>
					<td>${member.name} </td>
					<td>${member.email} </td>
					<td>${member.joinDate} </td>
				</tr>
			
			</c:forEach>
		</c:when>		
		</c:choose>	
	</table>
	<h3 style="text-align:center"><a href="${contextPath}/member/memberForm.do">Member Sign Up</a></h3>
</body>
</html>