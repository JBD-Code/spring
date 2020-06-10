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
		<tr align="center" bgcolor="lightgreen">
			<td width="20%"><b>Index</b></td>
			<td width="20%"><b>ID</b></td>
			<td width="20%"><b>Name</b></td>
			<td width="20%"><b>Title</b></td>
			<td width="30%"><b>WriteDate</b></td>
			<td width="20%"><b>ReadCount</b></td>
		</tr>
		
		<c:choose>
			<c:when test="${list == null }">
				<tr bgcolor="lightblue" align="center">
					<td colspan = "5">등록된 글이 없습니다 </td> 
				</tr>
			</c:when>
				<c:when test="${list!=null }">
					<c:forEach items="${list}" var="list">
						<tr align="center" >
						<td><a href="${contextPath}/boardContent?idx=${list.idx}">${list.idx}</a></td> 
						<td>${list.id} </td> 
						<td>${list.name} </td> 
						<td>${list.title}</td> 
						<td>${list.writeDate} </td> 
						<td>${list.readCount} </td> 
						</tr>
					</c:forEach>
			</c:when>
		</c:choose>	
	</table>
	<div style="text-align:center">
		<a href="${contextPath}/boardWriteForm">Board Write</a>
	</div>

</body>
</html>