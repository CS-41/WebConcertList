<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events By Customer</title>
<style>
body {background-color: LightBlue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
	<h1 class="h1">Events by Customer</h1>
	<form method = "post" action = "listNavigationServlet">
	<table>
	<c:forEach items = "${requestScope.allSales}" var="currentlist">
	<tr>
		<td><input type = "radio" name = "id" value = "${currentlist.id}"></td>
	</tr>
	<tr>
		<td colspan = "3">Order Date: ${currentlist.orderDate}</td></tr>
		
	<tr>
		<td colspan = "3">Customer: ${currentlist.customer.customerName}</td>
	</tr>
		
	<c:forEach var = "listVal" items = "${currentlist.listOfEvents}">
			<tr><td></td>
			<td colspan="3">
			${listVal.eventName}, ${listVal.eventLocation}
		</td>
		</tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToList">
	<input type = "submit" value = "delete" name = "doThisToList">
	<input type = "submit" value = "add" name = "doThisToList">
	</form>
	<br />
	<a href = "addItemsForListServlet">Create new ticket sale</a>
	<br />
	<a href = "index.html">Insert a new event</a>

</body>
</html>