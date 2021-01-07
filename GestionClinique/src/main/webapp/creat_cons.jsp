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
</head>

<h2 class="glyphicon glyphicon-log-in"><font color="#71F557">Bienvenue  Cher Medecin : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#6CB6F8">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/Projet%20JEE/GestionClinique/src/main/webapp/serviceM/med.jpg" width=100 height=100>
<form action="ajouteCon" method="post"> 
<table border="1" cellpadding=5>
	<caption><h3>Vous Pouvez ajouter la consulation de vos Patients sur ce formulaire</h3></caption>
	
	<tr>
	<th>Date Consultation: </th>
	<td><input type="date" name="date_cons" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Description: </th>
	<td><textarea id="story" name="Description" size="60" required="required" rows="4" cols="50"></textarea></td> 
	</tr>
	
	<tr>
	<th>Prix: </th>
	<td><input type="number" name="prix" size="45" required="required"/></td>
	</tr>
	
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