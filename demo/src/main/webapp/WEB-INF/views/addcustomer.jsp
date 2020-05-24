<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add customer</title>
</head>
<body>
	<form action="/demo/addCustomer" method="post">
		<table>
			<tr>
				<th>Name</th>
				<th>Service</th>
				<th>Phone</th>
				<th>Date</th>
			</tr>
			<tr>
				<td><input type="text" placeholder="Name" name="name"></td>
				<td><input type="text" placeholder="Service" name="service"></td>
				<td><input type="text" placeholder="Phone" name="phone"></td>
				<td><input type="text" placeholder="Date" name="date"></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>