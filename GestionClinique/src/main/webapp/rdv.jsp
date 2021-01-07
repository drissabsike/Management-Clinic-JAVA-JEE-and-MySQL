<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
    %>
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Cher Patient : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#66ffcc">
<div align="center">
<form action="ajout_rdv" method="post"> 
<table border="1" cellpadding=5>
	<caption><h1>Formulaire d'ajout Un Rendez-vous<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/icon/banner_1.svg" width=100 height=40></h1></caption>
	
	<tr>
	<th>Votre CIN : </th>
	<td><input type="text" name="cin" value="${cin}" size="45" readonly/></td>
	</tr>
	
	
	<tr>
	<th>Votre Nom et votre Prenom : </th>
	<td><input type="text" name="fullname" size="45" required="required"/></td>
	</tr>
	
	<tr>
	<th>Description	: </th>
	<td><textarea name="description" rows="4" cols="46" required="required"></textarea></td>
	</tr>
	
	<tr>
	<th>Date De Rendez-Vous yyyy/mm/dd</th>
	<td><input type="text" name="daterdv" size="45" required="required"/></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Ajouter"/>
		</td>
	</tr>

</table>
</form>
</div><br>
<div align="center"><a href="patient.jsp">Revenir vers le Menu</a><br></div>
</body>
</html>