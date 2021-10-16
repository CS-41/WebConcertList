<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ticket Sales!</title>
<style>
body {background-color: LightBlue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
	<h1 class="h1">Create a New Ticket Sale</h1>
	<form action = "createNewListServlet" method="post">
	Order Date: <input type="text" name = "month" placeholder="mm" size="4">
	<input type="text" name = "day" placeholder="dd" size="4">
	<input type="text" name = "year" placeholder="yyyy" size="4">
	Customer Name: <input type="text" name = "customerName"><br />
	
	Available Events:<br />
	<select name = "allEventsToAdd" multiple size = "6">
	<c:forEach items = "${requestScope.allEvents}" var="currentitem">
	<option value = "${currentitem.id}"> ${currentitem.eventName} | ${currentitem.eventLocation}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create sale and add events">
	</form>
	<a href="index.html">Go add new events instead</a>
</body>
</html>