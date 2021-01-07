<%@page import="com.mysql.cj.xdevapi.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Nouvelle Dossier Medical</title>
</head>
<h2 class="glyphicon glyphicon-log-in"><font color="#71F557">Bienvenue  Cher Medecin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#6CB6F8">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/Projet%20JEE/GestionClinique/src/main/webapp/serviceM/med.jpg" width=100 height=100>
<form action="ajouteCDM" method="post"> 
<table border="1" cellpadding=5>
	<caption><h3>Vous Pouvez Ajouter les dossiers medicaux de vous patients sur le formulaire suivant :</h3></caption>
	<tr>
	<th>Cin de Patient:</th>
	<td>
	<select  name="cin" required>
		<option>----Select----</option>
		<% try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
			String quey="select * from patient";
			PreparedStatement ps = con.prepareStatement(quey);
			ResultSet rs =ps.executeQuery(quey);
			while(rs.next()){
				%>
				<option value="<%=rs.getString("cin")%>"><%=rs.getString("cin")%></option>
				<% 
			}
		}catch(Exception e){out.print(e.getMessage());}
		%>
	</select>
	</td>
	</tr>
	
	<tr>
	<th>Nom Patient: </th>
	<td><input type="text" name="nom" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Prenom Patient: </th>
	<td><input type="text" name="prenom" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Telephone Patient: </th>
	<td><input type="number" name="telephone" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>La Maladie : </th>
	<td><input type="text" name="maladie" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Les Mediceaux : </th>
	<td><input type="text" name="mediceaux" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Nom Medcin : </th>
	<td><input type="text" name="medcin_nom" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>La Specialite du Medcin:</th>
	<td>
	<select  name="specialite" required>
		<option>----Select----</option>
		<% try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_clinique","root","");
			String quey="select * from medcin";
			PreparedStatement ps = con.prepareStatement(quey);
			ResultSet rs =ps.executeQuery(quey);
			while(rs.next()){
				%>
				<option value="<%=rs.getString("specialite")%>"><%=rs.getString("specialite")%></option>
				<% 
			}
		}catch(Exception e){out.print(e.getMessage());}
		%>
	</select>
	</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Ajouter"/>
		</td>
	</tr>

</table>
</form>
</div><br>
<div align="center"><a href="Medcin_page.jsp">Revenir vers le Menu</a><br></div>
</body>
</html>