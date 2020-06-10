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
	<form action="${contextPath}/boardWrite" method="post">
		<table align="center" border="1">
			<tr align="center" >
				<td width="10%" bgcolor="lightblue"><b>ID</b></td>
				<td align="left"><input type="text" name="id"></td>
			</tr>
			<tr align="center" >	
				<td width="15" bgcolor="lightblue"><b>Name</b></td>
				<td align="left"><input type="text" name="name"></td>
			</tr>
			<tr align="center" >	
				<td bgcolor="lightblue"><b>Title</b></td>
				<td align="left"><input type="text" name="title"></td>
			</tr>
			<tr align="center" >	
				<td bgcolor="lightblue"><b>Content</b></td>
				<td><textarea rows="30" cols="80" name="content"></textarea></td>
			</tr>
			<tr>
			<tr align="center" >	
				 <td colspan="2"><input type="submit" value="Write">		
				<input type="reset" value="reset"></td>		
		</table>	
	</form>
	<div style="text-align:center">
		<a href="${contextPath}/boardList">BoardList</a>
	</div>
</body>
</html>