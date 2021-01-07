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
<body bgcolor="#FEE7F0">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/reservation.png" width=100 height=100>
<form action="list" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:green;color:white;font-size:35;">La liste des Medcins de la Clinique</caption>
		<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Addresse</th>
		<th>Telephone</th>
		<th>Mail</th>
		<th>Specialite</th>
		<th>service</th>
		</tr>
		 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	 Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM medcin";
	PreparedStatement ps = con.prepareStatement(req);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getString("id")%></td>
		<td><%=rs.getString("nom")%></td>
		<td><%=rs.getString("prenom")%></td>
		<td><%=rs.getString("address")%></td>
		<td><%=rs.getString("telephone")%></td>
		<td><%=rs.getString("mail")%></td>
		<td><%=rs.getString("specialite")%></td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="deleteM?id=<%=rs.getString("id")%>">Supprimer</a>
		</td>
		</tr>
		<% } %>
		</table>
	</div>
</form><br>
<div align="center"><a href="index.jsp">Le Menu</a><br></div>
</body>
</html>







