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
	String fltno = request.getParameter("fltno");
	Statement stmt;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","rohitkeshri587","sql123");
	stmt= con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from flight where fltno='"+fltno+"';");
	if(rs.next()==false){
		out.println("Flight Does not Exists!");
	}
	else{
		String date=request.getParameter("date");
		String cname=request.getParameter("cname");
		String pno=request.getParameter("pno");
		
		int seat=(int)(Math.random()*500);
		
		stmt.executeUpdate("insert into seatres values('"+fltno+"','"+date+"','"+seat+"','"+cname+"','"+pno+"');");
		out.println("Booking Successfull!<br>");
		out.println("Flight No.:"+fltno+"<br>");
		out.println("Date:"+date+"<br>");
		out.println("Seat No.:"+seat+"<br>");
		out.println("Customer Name:"+cname+"<br>");
		out.println("Phone No.:"+pno+"<br>");
	}
	%>
	<a href="ReserveOnline.jsp">Back</a>
</body>
</html>