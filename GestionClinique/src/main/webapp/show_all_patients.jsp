<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
</head>
<h2 class="glyphicon glyphicon-log-in"><font color="#71F557">Bienvenue  Cher Medecin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#6CB6F8">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/Projet%20JEE/GestionClinique/src/main/webapp/serviceM/med.jpg" width=100 height=100>
<form action="#" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:#71F557;color:white;font-size:35;">La liste des patients</caption>
		<tr>
		<th style="th">ID</th>
		<th>Cin</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Telephone</th>
		<th>sexe</th>
		</tr>
		 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	 Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM patient";
	PreparedStatement ps = con.prepareStatement(req);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getInt("id")%></td>
		<td><%=rs.getString("cin")%></td>
		<td><%=rs.getString("nom")%></td>
		<td><%=rs.getString("prenom")%></td>
		<td><%=rs.getString("telephone")%></td>
		<td><%=rs.getString("sexe")%></td>
		</tr>
		<% } %>
		</table>
	</div>
</form><br>
<div align="center"><a href="Medcin_page.jsp">Le Menu</a><br></div>
</body>
</html>







