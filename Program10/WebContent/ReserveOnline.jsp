<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
	<form action="viewDetails.jsp" method="post">
	Flight No :<input type="text" name="fltno"/><br>
	Date : <input type="text" name="date"/><br>
	Customer Name: <input type=text name=cname><br>
	Phone No.: <input type=text name=pno ><br>
	<input type=submit value=Submit>
	</form>
	<br>
	<a href="viewFlights.jsp">View Flights</a>
</body>
</html>