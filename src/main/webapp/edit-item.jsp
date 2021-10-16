<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Event</title>
<style>
body {background-color: LightBlue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<h1 class="h1">Edit Event Item</h1>
<form action="editEventServlet" method="post">
Event: <input type="text" name="event" value="${itemToEdit.eventName}">
Event Location: <input type="text" name="location" value="${itemToEdit.eventLocation}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Save Edited Event">
</form>
</body>
</html>