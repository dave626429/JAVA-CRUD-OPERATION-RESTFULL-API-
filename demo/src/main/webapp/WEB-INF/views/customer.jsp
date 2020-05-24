<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/demo/delete">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Service</th>
				<th>Phone</th>
				<th>Date</th>
			</tr>
			<c:forEach items="${list}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.services}</td>
					<td>${customer.phone}</td>
					<td>${customer.date}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="text" name="phone" placeholder="Phone"/><input type="submit" value="delete"/>
	</form>
	
</body>
</html>