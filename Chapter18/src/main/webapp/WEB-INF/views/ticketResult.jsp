<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card Payment</title>
</head>
<body>
	<form> 
		<h3>Buy Ticket </h3>
		<table> 
			<tr>
				<td>
					<b>ConsumerID</b>
				</td>
				<td>
					<input type="text" name="consumerID">
				</td> 
			</tr>
			<tr>
				<td>
					<b>Amount</b>
				</td>
				<td>
					<input type="text" name="amount">
				</td> 
			</tr>
			<tr>
				<td><input type="submit" value="Pay">
				<input type="reset" value="Cancel"></td>
			<tr>	
			
		</table>
	
	</form>

</body>
</html>