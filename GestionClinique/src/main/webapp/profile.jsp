<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<img alt="" src="file:///C:/Users/HP/Desktop/GestionClinique/src/main/webapp/img/banner_img.png" width=100 height=100>
<form action="modifier" method="post"> 
<table border="1" cellpadding=5>
<caption><h1>Vous pouvez Modifier Votre Compte :</h1></caption>
	<tr>
	<th>CIN: </th>
	<td><input type="text" name="cin" size="45" value="${patient.cin}" readonly/></td>
	</tr>
	<tr>
	<th>Nom: </th>
	<td><input type="text" name="nom"  size="45" value="${patient.nom}" required="required"/></td>
	</tr>
	<tr>
	<th>Prenom: </th>
	<td><input type="text" name="prenom"  size="45" value="${patient.prenom}" required="required"/></td>
	</tr>
	<tr>
	<th>Telephone: </th>
	<td><input type="number" name="telephone"  size="45" value="${patient.telephone}" required="required"/></td>
	</tr>
	<tr>
	<th>Mail: </th>
	<td><input type="text" name="mail"  size="45" value="${patient.mail}" required="required"/></td>
	</tr>
	<tr>
	<th>Sexe: </th>
	<td><input type="text" name="sexe"  size="45" value="${patient.sexe}" required="required"/></td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Modifier"/>
		</td>
	</tr>
</table><br>
</form>
</div>
<div align="center"><a href="patient.jsp"><span class="glyphicon glyphicon-log-in">Revenir vers Le Menu</span></a>
</div>


</body>
</html>