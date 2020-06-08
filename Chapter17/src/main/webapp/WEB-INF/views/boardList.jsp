<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align:center">BoardList</h3> 
	<table border ="1" align="center"> 
		<tr align="center">
			<td width="20%">ID</td>
			<td width="20%">Name</td>
			<td width="20%">Title</td>
			<td width="30%">WriteDate</td>
			<td width="20%">ReadCount</td>
		</tr>
		
		<c:choose>
			<c:when test="${list == null }">
				<tr>
					<td colspan = "3">등록된 글이 없습니다 </td> 
				</tr>
			</c:when>
				<c:when test="${list!=null }">
					<c:forEach items="${list}" var="list">
						<tr align="center">
						<td>${list.id} </td> 
						<td>${list.name} </td> 
						<td>${list.title} </td> 
						<td>${list.writeDate} </td> 
						<td>${list.readCount} </td> 
						</tr>
					</c:forEach>
			</c:when>
		</c:choose>	
	</table>

</body>
</html>