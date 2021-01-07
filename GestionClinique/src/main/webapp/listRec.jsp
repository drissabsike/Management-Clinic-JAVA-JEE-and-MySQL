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
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Admin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#D209F6">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/reservation.png" width=100 height=100>
<form action="list" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:#F62209;color:white;font-size:35;">La liste des receptionniste de votre Clinique</caption>
		<tr>
		
		<th>Nom</th>
		<th>Prenom</th>
		<th>Telephone</th>
		<th>Adresse</th>
		<th>Mail</th>
		<th>La receptionniste</th>
		<th>Service</th>
		</tr>
		 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	 Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM receptionniste";
	PreparedStatement ps = con.prepareStatement(req);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		
		
		<td><%=rs.getString("nom")%></td>
		<td><%=rs.getString("prenom")%></td>
		<td><%=rs.getString("telephone")%></td>
		<td><%=rs.getString("address")%></td>
		<td><%=rs.getString("mail")%></td>
		<td><img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/statistique/recep.jpg"  width=100 height=100></td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="deleteR?id=<%=rs.getString("id")%>">Supprimer</a>
		</td>
		</tr>
		<% } %>
		</table>
	</div>
</form><br>
<div align="center"><a href="index.jsp">Le Menu</a><br></div>
</body>
</html>







