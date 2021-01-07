<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>L'affichage d'un Patient</title>
</head>
 <%
    if(session.getAttribute("cin")==null && session.getAttribute("mail")==null ){
    	response.sendRedirect("login.jsp");		
    }
    %>
<h2 class="glyphicon glyphicon-log-in"><font color="#66b3ff">Bienvenue  Cher Patient : </font></h2>
<h3 align="right">Votre addresse :<a href="#"> ${mail}</a></h3>
<body bgcolor="#ffff66">
<div align="center">
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/banner_img.png" width=100 height=100>
<form action="show" method="post"> 
<table border="1" cellpadding=5>
	<caption><h1>Votre Compte :</h1></caption>
	<tr>
	<th>CIN: </th>
	<td><input type="text" name="cin" disabled="disabled" size="45" value="${patient.cin}"/></td>
	</tr>
	<tr>
	<th>Nom: </th>
	<td><input type="text" name="nom" disabled="disabled" size="45" value="${patient.nom}"/></td>
	</tr>
	<tr>
	<th>Prenom: </th>
	<td><input type="text" name="prenom" disabled="disabled" size="45" value="${patient.prenom}"/></td>
	</tr>
	<tr>
	<th>Telephone: </th>
	<td><input type="number" name="telephone" disabled="disabled" size="45" value="${patient.telephone}"/></td>
	</tr>
	<tr>
	<th>Mail: </th>
	<td><input type="text" name="mail" disabled="disabled" size="45" value="${patient.mail}"/></td>
	</tr>
	<tr>
	<th>Sexe: </th>
	<td><input type="text" name="sexe" disabled="disabled" size="45" value="${patient.sexe}"/></td>
	</tr>

</table>
</form>
</div><br>
<div align="center"><a href="patient.jsp">Revenir vers le Menu</a>
</div>
</body>
</html>


