<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Sale!</title>
</head>
<body>
	<form action = "editListDetailsServlet" method = "post">
	<input type = "hidden" name = "id" value = "${saleToEdit.id}">
	Order date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input 
	type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" 
	name = "year" placeholder="yyyy" size="4" value= "${year}">
	Customer Name: <input type = "text" name = "customerName" value= "${saleToEdit.customer.customerName}"><br />
	<br />		
	Available Items:<br />
	<select name = "allEventsToAdd" multiple size = "6">
	<c:forEach items = "${requestScope.allEvents}" var ="currentitem">
	<option value = "${currentitem.id}"> ${currentitem.eventName} | ${currentitem.eventLocation}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value = "Edit sale and add events">
	</form>
	<a href = "index.html">Go add new events instead.</a>
</body>
</html>