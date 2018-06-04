<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Statement stmt;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
	stmt=con.createStatement();
	ResultSet rs = stmt.executeQuery("Select * from flight;");
	out.println("<table border=2>");
	out.println("<tr><td>Flight Number</td><td>Airline</td><td>Weekdays</td></tr>");
	while(rs.next())
	{
		out.println("<tr><td>"+rs.getString("fltno")+"</td><td>"+rs.getString("airline_name")+"</td><td>"+rs.getString("weekdays")+"</td></tr>");
	}
	out.println("</table>");
	%>
</body>
</html>