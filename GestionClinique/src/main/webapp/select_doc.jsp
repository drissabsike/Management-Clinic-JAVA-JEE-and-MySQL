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
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Cher Patient : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#66ffcc">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/banner_img.png" width=100 height=100>
<form action="afficherRdv" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:blue;color:white;font-size:35;">Informations sur Votre Dossiers Medical</caption>
		<tr>
		<th>CIN</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Telephone</th>
		<th>La Maladie</th>
		<th>Les Mediceaux</th>
		<th>Nom Medcin</th>
		<th>Le Medcin</th>
		<th>La Spécialité</th>
		<th>La Date Creation du Dossier</th>
		</tr>
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	String cin =(String)session.getAttribute("cin");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM dossier_medical WHERE cin=?";
	PreparedStatement ps = con.prepareStatement(req);
	ps.setString(1,cin);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getString("cin")%></td>
		<td><%=rs.getString("nom")%></td>
		<td><%=rs.getString("prenom")%></td>
		<td><%=rs.getString("telephone")%></td>
		<td><%=rs.getString("maladie")%></td>
		<td><%=rs.getString("mediceaux")%></td>
		<td><%=rs.getString("medcin_nom")%></td>
		<td><img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/doctor/doctor_3.png" width=100 height=100></td>
		<td><%=rs.getString("specialite")%></td>
		<td><%=rs.getString("date_creation")%></td>
		</tr>
		<% } %>
		</table>
		
	</div>
</form><br>
<div align="center"><a href="patient.jsp">Le Menu</a><br></div>
</body>
</html>







