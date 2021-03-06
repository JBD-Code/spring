<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Information</title>
</head>
<body>
	<form method="post"   action="${contextPath}/member/memberUpdate.do">
		<h1  style="text-align:center">Member Information</h1>	
		<table  align="center">
		    <tr>
		       <td width="200"><p align="right">ID</td>
		       <td width="400"><input type="text" name="id" value="${memberVO.id}" readonly="readonly"></td>
		    </tr>
		    <tr>
		        <td width="200"><p align="right">password</td>
		        <td width="400"><input type="password"  name="pwd" value="${memberVO.pwd}"></td>
		    </tr>
		    <tr>
		        <td width="200"><p align="right">Name</td>
		        <td width="400"><p><input type="text"  name="name" value="${memberVO.name}"></td>
		    </tr>
		    <tr>
		        <td width="200"><p align="right">E-Mail</td>
		        <td width="400"><p><input type="text"  name="email" value="${memberVO.email}"></td>
		    </tr>
		    <tr>
		        <td width="200"><p>&nbsp;</p></td>
		        <td width="400">
			       <input type="submit" value="Update">
			       <input type="reset" value="Reset">
		       </td>
		    </tr>
		</table>
		
	</form>
</body>
</html>