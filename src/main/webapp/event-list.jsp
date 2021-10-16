<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Concert List</title>
<style>
body {background-color: LightBlue;}
.h1{
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<h1 class="h1">List of Events</h1>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>| ${currentitem.eventName}</td>
	<td> - </td>
	<td>${currentitem.eventLocation} |</td>
</tr>
</c:forEach>
</table>
	<input type="submit" value="add" name="doThisToItem">
	<input type="submit" value="edit" name="doThisToItem">
	<input type="submit" value="delete" name="doThisToItem">
</form>
</body>
</html>
