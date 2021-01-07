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
<body>
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Cher Patient : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#66ffcc">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/banner_img.png" width=100 height=100>
<form action="afficherRdv" method="post">
	<div align="center">
		<table border="2">
		<caption align="top" style="background:blue;color:white;font-size:35;">Tableau de vos Consultations</caption>
		<tr>
		<th>CIN</th>
		<th>Date Consultation</th>
		<th>Description</th>
		<th>Medecin</th>
		<th>Le prix en dh</th>
		<th>Imprimer</th>
		</tr>
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	String cin =(String)session.getAttribute("cin");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM consultation WHERE cin=?";
	PreparedStatement ps = con.prepareStatement(req);
	ps.setString(1,cin);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
		<tr>
		<td><%=rs.getString("cin")%></td>
		<td><%=rs.getString("date_cons")%></td>
		<td><%=rs.getString("Description")%></td>
		<td><img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/doctor/doctor_3.png" width=100 height=100></td>
		<td><%=rs.getString("prix")%></td>
		<td>
			<% 
			int id=rs.getInt("id");
			   session.setAttribute("id", id);
			%>	
			<a href="payement.jsp?id=${id}&cin=${cin}">Payement</a>&nbsp;&nbsp;&nbsp;
			<a href="Imprimer?id=<%=rs.getInt("id")%>">Imprimer</a>
		</td>
		</tr>
		<% } %>
		</table>
		
	</div>
</form><br>
<div align="center"><a href="patient.jsp">Le Menu</a><br></div>
</body>
</html>







