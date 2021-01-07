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
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
	String cin =(String)session.getAttribute("cin");
	String mail =(String)session.getAttribute("mail");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
	//System.out.print("Connected");
	String req="SELECT * FROM receptionniste WHERE cin=? and mail=?";
	PreparedStatement ps = con.prepareStatement(req);
	ps.setString(1,cin);
	ps.setString(2,mail);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) { %>
<h2 class="glyphicon glyphicon-log-in"><font color="#71F557">Bienvenue  Cher Réceptionniste : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#FAAEA2">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/Projet%20JEE/GestionClinique/src/main/webapp/img3/team-2.jpg" width=100 height=100>
<form action="modifierRep" method="post"> 
<table border="1" cellpadding=5>
	<caption><h3>Vous Pouvez Modifier Vos Informations sur le Formulaire Suivant :</h3></caption>
	<tr>
	<th>CIN: </th>
	<td><input type="text" name="cin" readonly size="45" value="<%=rs.getString("cin")%>"/></td>
	</tr>
	<tr>
	<th>Nom: </th>
	<td><input type="text" name="nom"  size="45" value="<%=rs.getString("nom")%>"/></td>
	</tr>
	<tr>
	<th>Prenom: </th>
	<td><input type="text" name="prenom"  size="45" value="<%=rs.getString("prenom")%>"/></td>
	</tr>
	<tr>
	<th>Telephone: </th>
	<td><input type="number" name="telephone"  size="45" value="<%=rs.getString("telephone")%>"/></td>
	</tr>
	<tr>
	<th>Address: </th>
	<td><input type="text" name="address"  size="45" value="<%=rs.getString("address")%>"/></td>
	</tr>
	<tr>
	<th>Mail: </th>
	<td><input type="text" name="mail" size="45" value="<%=rs.getString("mail")%>"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Modifier"/>
		</td>
	</tr>
</table>
</form>
</div><br>
<div align="center"><a href="recep_page.jsp">Revenir vers le Menu</a>
</div>
</body>
<% } %>
</html>


