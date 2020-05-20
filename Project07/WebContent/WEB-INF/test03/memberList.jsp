<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%request.setCharacterEncoding("UTF-8"); %>    


<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<table border="1"  align="center"  width="80%">
	    <tr align="center"   bgcolor="lightgreen">
	      <td ><b>ID</b></td>
	      <td><b>Password</b></td>
	      <td><b>Name</b></td>
	      <td><b>E-Mail</b></td>
	      <td><b>JoinDate</b></td>
	      <td><b>Update</b></td>
	      <td><b>Delete</b></td>
	   </tr>
	   
	 <c:forEach var="member" items="${memberList}" >     
	   <tr align="center">
	      <td>${member.id}</td>
	      <td>${member.pwd}</td>
	      <td>${member.name}</td>
	      <td>${member.email}</td>
	      <td>${member.joinDate}</td>
	      <td><a href="${contextPath}/member/memberUpdate.do?id=${member.id}">Update</a></td>
	      <td><a href="${contextPath}/member/memberDelete.do?id=${member.id}">Delete</a></td>
	    </tr>
	  </c:forEach>   
	</table>
	<h3 style="text-align:center"><a href="${contextPath}/member/memberForm.do">Member Sign Up</a></h3>
</body>
</html>>