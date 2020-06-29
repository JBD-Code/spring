<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<table border=0 width="100%">
		<tr>
			<td>
				<a href="${contextPath}/main.do">
					<img src="${contextPath}/resources/image/duke2.png">
				</a>
			</td>	
			<td>
			  <h2>Spring Home Study</h2>
			</td>
			<td>
				<a href="#" ><h3>Login</h3></a>
			</td>
		</tr>
	
	</table>
</body>
</html>