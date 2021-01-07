<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
</head>
<h2 class="glyphicon glyphicon-log-in"><font color="#71F557">Bienvenue  Cher Réceptionniste : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#FAAEA2">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/Projet%20JEE/GestionClinique/src/main/webapp/img3/team-2.jpg" width=100 height=100>
<form action="afficherRdv" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:#D7DF2A;color:white;font-size:35;">La liste des rendez-vous</caption>
		<tr>
		<th>CIN</th>
		<th>Nom et Prenom</th>
		<th>Description</th>
		<th>La Date</th>
		<th>Option du rendez-vous</th>
		<th>Active /Désactive</th>
		</tr>
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM rendezvous";
	PreparedStatement ps = con.prepareStatement(req);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getString("cin")%></td>
		<td><%=rs.getString("nom_prenom")%></td>
		<td><%=rs.getString("description")%></td>
		<td><%=rs.getString("date_rdv")%></td>
		<td><%=rs.getString("activate")%></td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="deleteRDV?id=<%=rs.getInt("id")%>">NON ACCEPTÉ</a>&nbsp;
			<a href="ActivateRDV?id=<%=rs.getInt("id")%>">ACCEPTÉ</a>
		</td>
		</tr>
		<% } %>
		</table>
		
	</div>
</form><br>
<div align="center"><a href="recep_page.jsp">Le Menu</a><br></div>
</body>
</html>







