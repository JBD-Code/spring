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
	<h3 style="text-align:center">BoardWrite Form</h3> 
	<form action="${contextPath}/boardModify" method="post">
		<table align="center" border="1">
			<tr align="center" >
				<td width="10%" bgcolor="lightblue"><b>Index</b></td>
				<td align="left" ><input type="text" name="idx" value="${dto.idx}"></td>
			</tr>
			<tr align="center">
				<td width="5%" bgcolor="lightblue"><b>ID</b></td>
				<td align="left"><input type="text" name="id" value="${dto.id}"></td>
			</tr>
			<tr align="center" >	
				<td width="15" bgcolor="lightblue"><b>Name</b></td>
				<td align="left" colspan="3"><input type="text" name="name" value="${dto.name}"></td>
			</tr>
			<tr align="center" >	
				<td bgcolor="lightblue"><b>Title</b></td>
				<td align="left"><input type="text" name="title" value="${dto.title}"></td>
			</tr>
			<tr align="center" >	
				<td bgcolor="lightblue"><b>Content</b></td>
				<td><textarea rows="30" cols="80" name="content" >${dto.content}</textarea>
				</td>
			</tr>
			
			<tr align="center" >	
				<td colspan="2"><input type="submit" value="Write">
				<input type="reset" value="reset">
				<input type="button" value="delete" onclick="location.href='${contextPath}/boardDelete?idx=${dto.idx}'">
				</td>		
		</table>	
	</form>
	<div style="text-align:center">
		<p><a href="${contextPath}/boardList">BoardList</a></p>
		<p><a href="${contextPath}/boardWriteForm">BoardWriteForm</a></p>
	</div>
</body>
</html>