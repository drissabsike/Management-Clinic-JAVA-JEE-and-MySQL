<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<h2>List des Consultations de la BD</h2>
<head>
<meta charset="UTF-8">
</head>
<body>
<form action="#" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:blue;color:white;font-size:35;">Tableau des Consultations existe</caption>
		<tr>
		<th style="th">ID</th>
		<th>Date Consultation</th>
		<th>Description</th>
		<th>Prix</th>
		<th>Cin</th>
		</tr>
		 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	 Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM consultation";
	PreparedStatement ps = con.prepareStatement(req);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getInt("id")%></td>
		<td><%=rs.getString("date_cons")%></td>
		<td><%=rs.getString("Description")%></td>
		<td><%=rs.getString("prix")%></td>
		<td><%=rs.getString("cin")%></td>
		</tr>
		<% } %>
		</table>
	</div>
</form><br>
<div align="center"><a href="recep_page.jsp">Le Menu</a><br></div>
</body>
</html>







